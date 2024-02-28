package com.example.relacionesjpa.service;

import com.example.relacionesjpa.model.Profesor;
import com.example.relacionesjpa.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor saveProfesor(Profesor profesor)
    {
        profesor.setFechaCreacion(new Date());
        return profesorRepository.save(profesor);
    }

    public Optional<Profesor> findById(Integer id)
    {
        return profesorRepository.findById(id);
    }
}
