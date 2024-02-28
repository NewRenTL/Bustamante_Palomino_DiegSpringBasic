package com.example.relacionesjpa.mapper;


import com.example.relacionesjpa.dto.EstudianteDTO;
import com.example.relacionesjpa.model.Estudiante;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstudianteMapper {
    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Mapping(source = "estudiante.id",target = "idEstudiante")
    @Mapping(source = "estudiante.nombre",target = "nombreEstudiante")
    @Mapping(source = "estudiante.apellido",target = "apellidoEstudiante")
    @Mapping(source = "estudiante.email",target = "emailEstudiante")
    @Mapping(source = "estudiante.apoderado",target = "apoderadoDTO")
    EstudianteDTO estudianteToEstudianteDTO(Estudiante estudiante, @Context CycleAvoidMappingContext cycleAvoidMappingContext);
}
