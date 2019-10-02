package net.mate.testmaven.cache;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.mate.testmaven.controller.dto.SpecificationRequest;
import net.mate.testmaven.model.BaseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ListCache<T extends BaseEntity, SCR extends SpecificationRequest> {

    @Getter
    private Map<SCR, List<Long>> cache = new HashMap<>();

    private Function<SCR, List<T>> findBySpecification;
    private Function<List<Long>, List<T>> findByIds;

    public void initFunctions(Function<SCR, List<T>> fBySp, Function<List<Long>, List<T>> fById) {
        this.findBySpecification = fBySp;
        this.findByIds = fById;
    }

    public List<T> getEntities(SCR specificationRequest) {
        List<Long> ids = cache.get(specificationRequest);
        if (ids == null) {
            log.info("<< CACHE: 1-st request >>");
            List<T> entities = findBySpecification.apply(specificationRequest);

            put(entities, specificationRequest);
            return entities;
        } else {
            log.info("<< CACHE: Second request >>");
            return loadFromCache(ids);
        }
    }

    private List<T> loadFromCache(List<Long> ids) {
        return findByIds.apply(ids);
    }

    private void put(List<T> entities, SCR specificationRequest) {
        cache.put(specificationRequest, entities.stream().map(BaseEntity::getId).collect(Collectors.toList()));
    }

}
