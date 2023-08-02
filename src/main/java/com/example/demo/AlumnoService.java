package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
    private final AlumnoRepository AlumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.AlumnoRepository = alumnoRepository;
    }

  
}

