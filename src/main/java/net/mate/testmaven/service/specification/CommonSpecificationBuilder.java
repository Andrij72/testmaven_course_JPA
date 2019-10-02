package net.mate.testmaven.service.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

import static net.mate.testmaven.util.SpecificationCriteriaUtil.buildRange;

public abstract class CommonSpecificationBuilder<T> {

    private static final String NAME_KEY = "name";
    private static final String CREATED_DATE_KEY = "createdDate";

    public Specification<T> build(SpecificationCriteria criteria){
        return Specification.where(buildName(criteria.getName()))
                            .and (buildCreatedDateRange(criteria));
    }

    private Specification<T> buildName(String name){
        return (root, query, builder) -> Objects.isNull(name)
                ? null
                : builder.like(root.get(NAME_KEY), name + "%");
    }
    private Specification<T> buildCreatedDateRange(SpecificationCriteria criteria){
        return buildRange(criteria.getCreatedDateStart(), criteria.getCreatedDateEnd(), (root)-> root.get(CREATED_DATE_KEY));
    }
}
