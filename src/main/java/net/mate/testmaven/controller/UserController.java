package net.mate.testmaven.controller;

import net.mate.testmaven.controller.dto.Course;
import net.mate.testmaven.controller.dto.SpecificationRequest;
import net.mate.testmaven.service.CourseService;
import net.mate.testmaven.service.UserService;
import net.mate.testmaven.transformer.CourseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
   private CourseTransformer courseTransformer;

    @Autowired
   private CourseService courseService;

    @PostMapping("/search")
    public List<Course> findAllBySpecification(@RequestBody SpecificationRequest request){
        return courseTransformer.buildCourses(courseService.findAllByCriteria(request));
    }
}
