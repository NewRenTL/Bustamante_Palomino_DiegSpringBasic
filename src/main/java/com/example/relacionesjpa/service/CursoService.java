package com.example.relacionesjpa.service;

import com.example.relacionesjpa.model.Curso;
import com.example.relacionesjpa.model.Estudiante;
import com.example.relacionesjpa.repository.CursoRepository;
import com.example.relacionesjpa.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Curso saveCurso(Curso curso)
    {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> findById(Integer id)
    {
        return cursoRepository.findById(id);
    }

    public Optional<Curso> asignarEstudiantesACurso(Integer cursoId, List<Integer> listaIdsEstudiantes) {
        Optional<Curso> cursoOptional = cursoRepository.findById(cursoId);
        if(cursoOptional.isEmpty())
        {
            return Optional.empty();
        }
        Curso curso = cursoOptional.get();
        List<Estudiante> estudiantes = estudianteRepository.findAllById(listaIdsEstudiantes);
        for (Estudiante estudiante:estudiantes)
        {
            curso.agregarEstudiante(estudiante);
        }
        cursoRepository.save(curso);
        return cursoOptional;
    }

    public Optional<Curso> asignarUnEstudianteACurso(Integer idCourse,Integer idEstudiante)
    {
        Optional<Curso> optionalCourse = cursoRepository.findById(idCourse);
        if(optionalCourse.isEmpty())
        {
            return Optional.empty();
        }
        Optional<Estudiante> optionalStudent = estudianteRepository.findById(idEstudiante);
        if (optionalStudent.isEmpty())
        {
            return Optional.empty();
        }
        Curso curso = optionalCourse.get();

        List<Estudiante> estudiantesX = curso.getEstudiantes();

        estudiantesX.add(optionalStudent.get());

        curso.setEstudiantes(estudiantesX);

        cursoRepository.save(curso);

        return Optional.of(curso);

    }




}
