package com.example.relacionesjpa.service;

import com.example.relacionesjpa.dto.ApoderadoDTO;
import com.example.relacionesjpa.mapper.ApoderadoMapper;
import com.example.relacionesjpa.model.Apoderado;
import com.example.relacionesjpa.repository.ApoderadoRepository;
import com.example.relacionesjpa.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.relacionesjpa.mapper.CycleAvoidMappingContext;

import java.util.Date;
import java.util.Optional;


@Service
public class ApoderadoService {

    private ApoderadoRepository apoderadoRepository;

    @Autowired
    private CycleAvoidMappingContext cycleAvoidMappingContext;

    public ApoderadoService(ApoderadoRepository apoderadoRepository) {
        this.apoderadoRepository = apoderadoRepository;
    }

    public BaseResponse saveApoderado(Apoderado apoderado)
    {
        Optional<Apoderado> apoderadoBd = apoderadoRepository.findByEmail(apoderado.getEmail());

        if(apoderadoBd.isPresent())
        {
            return new BaseResponse(400,"The ApoderadoEmail already exists", false, Optional.empty());
        }


        apoderado.setRole("apoderado");
        apoderado.setFechaCreacion(new Date());
        apoderadoRepository.save(apoderado);
        ApoderadoDTO apoderadoDTO = ApoderadoMapper.INSTANCE.apoderadoToApoderadoDTO(apoderado,cycleAvoidMappingContext);
        return new BaseResponse(200,"Apoderado has been successfully",true,Optional.of(apoderadoDTO));
        //apoderado.setFechaCreacion(new Date());
        //return apoderadoRepository.save(apoderado);
    }

    public BaseResponse findById(Integer id)
    {
        //We look for the representative
        Optional<Apoderado> apoderadoBd = apoderadoRepository.findById(id);
        if(apoderadoBd.isPresent())
        {
            ApoderadoDTO apoderadoDTO = ApoderadoMapper.INSTANCE.apoderadoToApoderadoDTO(apoderadoBd.get(),cycleAvoidMappingContext);
            return new BaseResponse(200,"Apoderado found",true,Optional.of(apoderadoDTO));
        }

        return new BaseResponse(404,"Apoderado not found",false,Optional.empty());
    }


}
