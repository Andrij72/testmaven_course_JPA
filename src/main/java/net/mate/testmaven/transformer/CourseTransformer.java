package net.mate.testmaven.transformer;


import net.mate.testmaven.controller.dto.Course;
import net.mate.testmaven.controller.dto.Section;
import net.mate.testmaven.model.CourseEntity;
import net.mate.testmaven.model.SectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class CourseTransformer {

    @Autowired
    private SectionTransformer sectionTransformer;

    public List<Course> buildCourses(List<CourseEntity> entities) {
        return entities.stream()
                .map(this::buildCourse)
                .collect(toList());    }


    public Course buildCourse(CourseEntity courseEntity) {
        List<Section> sections = sectionTransformer.buildSections(courseEntity.getSections());
        return Course.builder()
                .name(courseEntity.getName())
                .cost(courseEntity.getCost())
                .sections(sections)
                .build();
    }

    public CourseEntity buildCourseEntity(Course course) {
        List<SectionEntity> sections = course.getSections() == null ?
                Collections.emptyList() : sectionTransformer.buildSectionsEntities(course.getSections());
        CourseEntity entity = new CourseEntity();
        entity.setName(course.getName());
        entity.setCost(course.getCost());
        entity.setSections(sections);
        return entity;
    }
}