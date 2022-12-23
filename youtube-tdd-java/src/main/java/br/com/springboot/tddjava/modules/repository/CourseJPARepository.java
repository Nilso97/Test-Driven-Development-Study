package br.com.springboot.tddjava.modules.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.springboot.tddjava.modules.model.Course;

@Repository
public interface CourseJPARepository extends JpaRepository<Course, UUID> {
    
    // Query para ser realizado os Testes de Integração com o Banco de dados
    @Query("SELECT c FROM Course c WHERE c.name = :name")
    public Course findByName(@Param("name") String name);

    // public Course findByName(String name);
}
