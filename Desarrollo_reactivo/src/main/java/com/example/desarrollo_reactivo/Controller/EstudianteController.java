package com.example.desarrollo_reactivo.Controller;


import com.example.desarrollo_reactivo.Repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EstudianteController {

    @Autowired
    EstudianteRepository estudent;

    @GetMapping(path = "/all")
    public Map<String, Object> GetallStudents() {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("Estudiantes", estudent.findAll());
        return paramsMap;
    }
}
