package com.example.reactive_programing_mysql.Controller;

import com.example.reactive_programing_mysql.Models.Students;
import com.example.reactive_programing_mysql.Repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentrep;

    @GetMapping
    public Flux<Students> findAll() {
        return studentrep.findAll();
    }


    @PostMapping
    public Mono Agregar(@RequestBody Students student) {

        if (student.getName() == null || student.getEmail() == null) {
            return false;
        }

        return studentrep.save(student);
    }

}
