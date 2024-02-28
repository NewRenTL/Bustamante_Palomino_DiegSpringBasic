package com.example.relacionesjpa.mapper;



import com.example.relacionesjpa.dto.ApoderadoDTO;
import com.example.relacionesjpa.model.Apoderado;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApoderadoMapper {
    ApoderadoMapper INSTANCE = Mappers.getMapper(ApoderadoMapper.class);

    @Mapping(source = "apoderado.id",target = "idApoderado")
    @Mapping(source = "apoderado.nombre",target = "nombreApoderado")
    @Mapping(source = "apoderado.apellido",target = "apellidoApoderado")
    @Mapping(source = "apoderado.email",target = "emailApoderado")
    @Mapping(source = "apoderado.estudiantesDTO",target = "estudiantes")
    ApoderadoDTO apoderadoToApoderadoDTO(Apoderado apoderado, @Context CycleAvoidMappingContext cycleAvoidMappingContext);
}
