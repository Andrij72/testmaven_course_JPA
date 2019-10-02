package net.mate.testmaven.service.specification;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecificationBuilder<R> extends CommonSpecificationBuilder<R> {

    //private static final String PROGRES_KEY = "progres";

    @Override
    public Specification<R> build(SpecificationCriteria criteria) {
        return Specification.where(super.build(criteria))
                .and(buildProgres(criteria));
    }

    private Specification<R> buildProgres(SpecificationCriteria criteria) {
        return null;
    }

}
