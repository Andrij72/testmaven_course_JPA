package net.mate.testmaven.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Section {
    private String name;
    private String comment;
    //private List<Lesson> lessons;
}