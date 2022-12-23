package br.com.springboot.tddjava.modules.repository;

import br.com.springboot.tddjava.modules.model.Course;

public interface ICourseRepository {
    
    public Course findByName(String name);

    public Course save(Course course);
}
