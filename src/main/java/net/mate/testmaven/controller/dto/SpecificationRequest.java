package net.mate.testmaven.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecificationRequest {
    private String login; // by user login
    private String name; // by every Entity which contain name as field
    private String content; // by lesson, comment

    private Long costStart;
    private Long costEnd;

    private Long createdDateStart;
    private Long createdDateEnd;
}
