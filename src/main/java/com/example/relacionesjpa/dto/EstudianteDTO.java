package com.example.relacionesjpa.dto;

import com.example.relacionesjpa.model.Apoderado;
import lombok.Getter;
import lombok.Setter;


//This is all that customer sees

@Getter
@Setter
public class EstudianteDTO {

    private Integer idEstudiante;

    private String nombreEstudiante;

    private String apellidoEstudiante;

    private String emailEstudiante;

    private ApoderadoDTO apoderadoDTO;
}

