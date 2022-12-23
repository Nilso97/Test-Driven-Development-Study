package br.com.springboot.tddjava.modules.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.tddjava.modules.model.Course;

@Service
public class CourseRepository implements ICourseRepository {

    @Autowired
    private CourseJPARepository courseJPARepository;

    @Override
    public Course findByName(String name) {
        return this.courseJPARepository.findByName(name);
    }

    @Override
    public Course save(Course course) {
        return this.courseJPARepository.save(course);
    }
    
}
