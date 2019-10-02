package net.mate.testmaven.model;

import lombok.*;
import javax.persistence.*;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "course")
public class CourseEntity extends CreatableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Long cost;

    @Column(name="begin_date")
    private Long begin_date;

    @Column(name="end_date")
    private Long end_date;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<SectionEntity> sections = new ArrayList<>();
}
