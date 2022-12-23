package br.com.springboot.tddjava.modules.service;

import org.springframework.stereotype.Service;

import br.com.springboot.tddjava.modules.model.Course;
import br.com.springboot.tddjava.modules.repository.ICourseRepository;

@Service
public class CreateCourseService {

    // Utilizado nos Testes de Integração com Banco de dados
    // @Autowired
    // private CourseRepository courseRepository;

    // Utilizado para realizar os Testes Unitários
    private ICourseRepository courseRepository;

    public CreateCourseService(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public Course execute(Course course) {

        // Validar se o Curso existe
        Course existedCourse = courseRepository.findByName(course.getName());

        // Se SIM -> retorna erro
        if (existedCourse != null) {
            throw new Error("Este curso já existe em nosso Banco de Dados!");
        }

        // Se NÂO -> Salva e retorna novo Curso
        return this.courseRepository.save(course);
    }
}
