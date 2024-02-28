package com.example.relacionesjpa.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="estudiantes")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudiante_id")
    @JsonProperty("id")
    private Integer id;

    private String nombre;

    private String apellido;

    private String contrasenia;

    private String role;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    private boolean estado;

    private String email;

    @ManyToOne
    @JoinColumn(name = "apoderado_id_fk")
    private Apoderado apoderado;



    // Estudiante >----< Curso
    // So ignore estudiantes property in the curse
    @ManyToMany
    @JoinTable(name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "estudiante_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "curso_id_fk"))
    //@JsonIgnoreProperties("estudiantes")
    //@JsonBackReference
    //@JsonIgnoreProperties
    List<Curso> cursos;



}
