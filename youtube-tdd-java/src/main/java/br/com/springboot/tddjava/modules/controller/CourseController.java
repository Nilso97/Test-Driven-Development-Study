package br.com.springboot.tddjava.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.tddjava.modules.model.Course;
import br.com.springboot.tddjava.modules.repository.CourseRepository;
import br.com.springboot.tddjava.modules.service.CreateCourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    // @Autowired
    // private CreateCourseService createCourseService;

    @Autowired
    private CourseRepository courseRepository;
    
    @PostMapping
    public Course createCourse(@RequestBody Course course) {

        CreateCourseService createCourseService = new CreateCourseService(courseRepository);
        return createCourseService.execute(course);
    }
}
