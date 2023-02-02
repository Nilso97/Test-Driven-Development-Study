package br.com.springboot.tddwithmockmvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.tddwithmockmvc.model.BookingModel;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, String> {
    
    public Optional<BookingModel> findByReserveName(String name);
}
