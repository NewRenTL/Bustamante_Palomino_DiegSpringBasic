package com.example.relacionesjpa.controller;


import com.example.relacionesjpa.model.Curso;
import com.example.relacionesjpa.model.Profesor;
import com.example.relacionesjpa.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profesor")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProfesor(@RequestBody Profesor profesor)
    {
        Profesor profesorSave = profesorService.saveProfesor(profesor);
        return ResponseEntity.ok(profesorSave);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id)
    {
        Optional<Profesor> profesorObtained = profesorService.findById(id);
        if(profesorObtained.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found");
        }
        return ResponseEntity.ok(profesorObtained.get());
    }

}
