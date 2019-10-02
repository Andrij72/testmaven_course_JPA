package net.mate.testmaven.transformer;

import net.mate.testmaven.controller.dto.SpecificationRequest;
import net.mate.testmaven.service.specification.SpecificationCriteria;

public class SpecificationTransformer {
    public static SpecificationCriteria buildCriteria(SpecificationRequest request){
        return SpecificationCriteria
                .builder()
                .name(request.getName())
                .login(request.getLogin())
                .content(request.getContent())
                .costStart(request.getCostStart())
                .costEnd(request.getCostEnd())
                .createdDateStart(request.getCreatedDateStart())
                .createdDateEnd(request.getCreatedDateEnd())
                .build();
    }
}
