package net.mate.testmaven.service.specification;

import org.springframework.data.jpa.domain.Specification;

import static net.mate.testmaven.util.SpecificationCriteriaUtil.buildRange;

public class CourseSpecificationBuilder<R> extends CommonSpecificationBuilder<R> {
    private static final String COST_KEY = "cost";

    @Override
    public Specification<R> build (SpecificationCriteria criteria){
        return Specification.where(super.build(criteria))
                .and(buildCostRange(criteria));
    }

    private Specification<R> buildCostRange(SpecificationCriteria criteria){
        return buildRange(criteria.getCostStart(), criteria.getCostEnd(), (r)-> r.get(COST_KEY));
    }
}
