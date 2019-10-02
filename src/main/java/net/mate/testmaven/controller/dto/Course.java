package net.mate.testmaven.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Course {
    private String name;
    private long cost;
    private List<Section> sections;
    private Long begin_date;
    private Long end_date;
}
