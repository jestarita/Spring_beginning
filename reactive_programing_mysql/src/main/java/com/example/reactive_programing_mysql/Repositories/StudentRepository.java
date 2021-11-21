package com.example.reactive_programing_mysql.Repositories;

import com.example.reactive_programing_mysql.Models.Students;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StudentRepository extends ReactiveCrudRepository<Students, Integer> {

}
