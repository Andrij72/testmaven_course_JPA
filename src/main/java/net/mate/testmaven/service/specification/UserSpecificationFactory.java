package net.mate.testmaven.service.specification;

import net.mate.testmaven.model.CourseEntity;
import net.mate.testmaven.model.UserEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

    @Component
    public class UserSpecificationFactory {
        private static final UserSpecificationBuilder<UserEntity> SPECIFICATION_BUILDER = new UserSpecificationBuilder<>();

        public Specification<UserEntity> build(SpecificationCriteria searchCriteria) {
            return SPECIFICATION_BUILDER.build(searchCriteria);
        }
    }
