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
@Table(name = "apoderados")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Apoderado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apoderado_id")
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

    @OneToMany(mappedBy = "apoderado")
    //To avoid a infinite loop
    //@JsonIgnoreProperties("apoderado")
    List<Estudiante> estudiantesDTO;


}
