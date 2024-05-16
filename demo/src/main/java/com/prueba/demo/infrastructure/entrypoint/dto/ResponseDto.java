package com.prueba.demo.infrastructure.entrypoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ResponseDto<T> {
    private T data;
    private Integer status;
    private String message;
}
