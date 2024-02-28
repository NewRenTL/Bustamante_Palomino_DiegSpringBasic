package com.example.relacionesjpa.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cursos")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    @JsonProperty("id")
    private Integer id;

    // // ADD STUDIANTES  -> ID DEL CURSO , REQUIRE BODY (LISTA DE ENTERS IDS)
    // CURSO -> ESTUDAINTES-> QUE ES LO QUE YO QUIETRO -> TENERL OS DATOS DEL ESTUDAINTE, PERO SIN ALS REFERENCIAS
    // PORQUE CUANDO YO HAGO LAS REFERENCIAS -> SE VA REFERENCIAR Y OTRA VEZ Y ESE ES MI MIEDO DE QUE HAYA BUCLE INFINITO DE JSONS

    private String nombre;

    //Curso >--- Profesor
    //So ignore cursos property in the course
    @ManyToOne
    @JoinColumn(name = "profesor_id_fk")
    //@JsonIgnoreProperties("cursos")
    private Profesor profesor;


    //
    @ManyToMany(mappedBy = "cursos")
    //@JsonIgnoreProperties("cursos")
    //@JsonBackReference
    List<Estudiante> estudiantes;

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiantes == null) {
            estudiantes = new ArrayList<>();
        }
        estudiantes.add(estudiante);
        estudiante.getCursos().add(this);
    }
}
