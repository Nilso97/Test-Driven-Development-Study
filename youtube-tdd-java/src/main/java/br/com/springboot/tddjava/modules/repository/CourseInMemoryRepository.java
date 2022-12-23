package br.com.springboot.tddjava.modules.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.springboot.tddjava.modules.model.Course;

public class CourseInMemoryRepository implements ICourseRepository {

    private List<Course> courses; /* = new ArrayList<>(); */

    public CourseInMemoryRepository() {
        this.courses = new ArrayList<>();
    }

    // @Override
    // public Course findByName(String name) {
    //     this.courses.stream().filter(new Predicate<Course>() {
    //         @Override
    //         public boolean test(Course course) {
    //             if (!(course.getName()).equals(name)) {
    //                 return false;
    //             }
    //             return true;
    //         }
    //     }).findFirst();
    //     return null;
    // }

    // Com Lambda Functions
    @Override
    public Course findByName(String name) {
        Optional<Course> courseByName = this.courses.stream()
                .filter(course -> course.getName() == name)
                .findFirst();
        return courseByName.orElse(null);
    }

    @Override
    public Course save(Course course) {
        this.courses.add(course);
        course.setId(UUID.randomUUID());
        return course;
    }
}
