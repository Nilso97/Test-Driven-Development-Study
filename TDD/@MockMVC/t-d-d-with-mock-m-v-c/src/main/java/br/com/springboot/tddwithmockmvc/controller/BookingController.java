package br.com.springboot.tddwithmockmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.tddwithmockmvc.model.BookingModel;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    
    @GetMapping
    @ResponseBody
    public String getAll() {
        return "OK";
    }

    @PostMapping("/save")
    public ResponseEntity<BookingModel> save(BookingModel bookingModel) {
        return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
    }
}
