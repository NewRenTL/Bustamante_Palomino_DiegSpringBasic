package com.example.relacionesjpa.dto;

import com.example.relacionesjpa.model.Estudiante;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApoderadoDTO {

    private Integer idApoderado;
    private String nombreApoderado;

    private String apellidoApoderado;

    private String emailApoderado;


    List<EstudianteDTO> estudiantes;

}
