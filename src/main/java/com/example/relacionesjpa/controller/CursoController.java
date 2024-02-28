package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.model.Curso;
import com.example.relacionesjpa.model.Estudiante;
import com.example.relacionesjpa.service.CursoService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
    @RequestMapping("/api/v1/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCurso(@RequestBody Curso curso)
    {
        Curso cursoGuardado = cursoService.saveCurso(curso);
        return ResponseEntity.ok(cursoGuardado);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id)
    {
        Optional<Curso> cursoObtained = cursoService.findById(id);
        if(cursoObtained.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso not found");
        }
        return ResponseEntity.ok(cursoObtained);
    }

    @PostMapping("/add/listaEstudiantes/{cursoId}")
    public ResponseEntity<?> findEstudiantesById(@PathVariable Integer cursoId, @RequestBody List<Integer> listEstudiante)
    {
        //Lsita de enteros -> Ids de los estudiantes
        Optional<Curso> curso = cursoService.asignarEstudiantesACurso(cursoId,listEstudiante);
        if(curso.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
        return ResponseEntity.ok(curso);
    }

    @PostMapping("add/addStudent/{cursoId}/{studentId}")
    public ResponseEntity<?>  addStudentToCurso(@PathVariable("cursoId") Integer cursoId,@PathVariable("studentId") Integer studentId)
    {
        Optional<Curso> curso = cursoService.asignarUnEstudianteACurso(cursoId,studentId);
        if(curso.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course Not Found or Student Not Found");
        }
        return ResponseEntity.ok(curso.get());
    }
}
