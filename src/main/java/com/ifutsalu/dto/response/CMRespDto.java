package com.ifutsalu.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CMRespDto<T> {

    private int code;
    private String message;
    private T data;
}
