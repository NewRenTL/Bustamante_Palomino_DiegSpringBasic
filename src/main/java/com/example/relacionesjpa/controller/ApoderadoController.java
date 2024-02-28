package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.model.Apoderado;
import com.example.relacionesjpa.response.BaseResponse;
import com.example.relacionesjpa.service.ApoderadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/apoderado")
public class ApoderadoController {
    @Autowired
    private ApoderadoService apoderadoService;


    @PostMapping("/save")
    public BaseResponse saveApoderado(@RequestBody Apoderado apoderado)
    {
        BaseResponse apoderadoGuardado = apoderadoService.saveApoderado(apoderado);
        return apoderadoGuardado;
    }

    @GetMapping("/get/{id}")
    public BaseResponse findById(@PathVariable Integer id)
    {
        BaseResponse apoderadoObtained = apoderadoService.findById(id);
        /*
        if(apoderadoObtained.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apoderado not found");
        }
        */
        return apoderadoObtained;
    }
}
