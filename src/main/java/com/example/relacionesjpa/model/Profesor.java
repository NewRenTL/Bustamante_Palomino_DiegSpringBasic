package com.example.relacionesjpa.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "profesores")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
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

    private String email;

    //profesor ---< Cursos
    //Ignore Profesor property in the course
    @OneToMany(mappedBy = "profesor")
    //@JsonIgnoreProperties("profesor")
    //@JsonBackReference
    List<Curso> cursos;
}
