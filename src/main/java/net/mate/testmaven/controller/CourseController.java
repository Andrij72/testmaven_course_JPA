package net.mate.testmaven.controller;

import net.mate.testmaven.controller.dto.Course;
import net.mate.testmaven.controller.dto.SpecificationRequest;
import net.mate.testmaven.exception.BaseHandler;
import net.mate.testmaven.service.CourseService;
import net.mate.testmaven.transformer.CourseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseHandler {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseTransformer courseTransformer;

    @GetMapping
    public List<Course> findAll() {
        return courseTransformer.buildCourses(courseService.findAll());
    }

    @PostMapping
    public void createCourse(@RequestBody Course course) {
        courseService.createCourse(courseTransformer.buildCourseEntity(course));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCourse(@PathVariable(name = "id") Long id) {
        courseService.deleteCourseById(id);
    }

    @GetMapping(path = "/find/{name}")
    public Course findCourseByName(@PathVariable(name = "name") String name) {
        return courseTransformer.buildCourse(courseService.getByName(name));
    }

    @GetMapping(path = "/{id}")
    public Course findById(@PathVariable(name = "id") Long id) {
        return courseTransformer.buildCourse(courseService.findCourseById(id));
    }

    @PostMapping("/search")
    public List<Course> findAllBySpecification(@RequestBody SpecificationRequest request){
    return courseTransformer.buildCourses(courseService.findAllByCriteria(request));
    }
}
