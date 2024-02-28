package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.model.Estudiante;
import com.example.relacionesjpa.service.EstudianteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/estudiante")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEstudiante(@RequestBody Estudiante estudiante)
    {
        Estudiante estudianteGuardado = estudianteService.saveEstudiante(estudiante);
        return ResponseEntity.ok(estudianteGuardado);
    }

    @GetMapping("/get/{id}")
    public  ResponseEntity<?> findById(@PathVariable Integer id)
    {
        Optional<Estudiante> estudianteObtained = estudianteService.findById(id);
        if(estudianteObtained.isEmpty())
        {
            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
        return ResponseEntity.ok(estudianteObtained.get());
    }
}
