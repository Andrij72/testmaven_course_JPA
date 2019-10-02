package net.mate.testmaven.service;


import net.mate.testmaven.controller.dto.Course;
import net.mate.testmaven.controller.dto.SpecificationRequest;
import net.mate.testmaven.model.CourseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseService {

    void createCourse(CourseEntity course);

    List<CourseEntity> findAll();

    List<CourseEntity> findAllByIds(List<Long> ids);

    void deleteCourseById(Long id);

    void update(Long id, Course course);

    CourseEntity findCourseById(Long id);

    CourseEntity getByName(String name);

    @Transactional
    List<CourseEntity> findAllByCriteria(SpecificationRequest request);

}
