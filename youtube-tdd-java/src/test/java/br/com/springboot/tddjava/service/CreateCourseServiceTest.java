package br.com.springboot.tddjava.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import br.com.springboot.tddjava.modules.model.Course;
import br.com.springboot.tddjava.modules.repository.CourseInMemoryRepository;
import br.com.springboot.tddjava.modules.service.CreateCourseService;

public class CreateCourseServiceTest {
    
    @Test
    public void should_be_able_to_create_a_new_course() {

        // Criar tabela Course(Entidade) - id, name, description e workload

        // Criar um novo curso
        Course course = new Course();
        course.setName("Curso Test Driven Development (TDD)");
        course.setDescription("Implementando TDD no Java Com JUNIT");
        course.setWorkload(60);

        // Criar Repositório de Course
        CourseInMemoryRepository courseInMemoryRepository = new CourseInMemoryRepository();
        
        // Criar um novo Service
        CreateCourseService createCourseService = new CreateCourseService(courseInMemoryRepository);
        Course createCourse = createCourseService.execute(course);

        assertNotNull(createCourse.getId());
    }

    @Test(expected = Error.class)
    public void should_not_be_able_to_create_a_new_course_if_exists() {

        Course course = new Course();
        course.setName("Curso Test Driven Development (TDD) ---> Not_Create_Course");
        course.setDescription("Implementando TDD no Java Com JUNIT ---> Not_Create_Course");
        course.setWorkload(00);

        CourseInMemoryRepository courseInMemoryRepository = new CourseInMemoryRepository();

        CreateCourseService createCourseService = new CreateCourseService(courseInMemoryRepository);
        createCourseService.execute(course);
        createCourseService.execute(course);
    }
}
