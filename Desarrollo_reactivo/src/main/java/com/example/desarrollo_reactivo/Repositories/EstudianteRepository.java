package com.example.desarrollo_reactivo.Repositories;

import com.example.desarrollo_reactivo.Models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends CrudRepository<StudentModel, Integer> {
}
