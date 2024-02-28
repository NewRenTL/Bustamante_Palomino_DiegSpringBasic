package com.example.relacionesjpa.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
public class BaseResponse {
    private int codigo;
    private String message;

    private boolean success;

    //Java can infer the data with the Optional class
    private Optional data;

}
