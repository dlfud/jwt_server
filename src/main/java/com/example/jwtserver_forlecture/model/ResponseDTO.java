package com.example.jwtserver_forlecture.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseDTO {
    String code;
    String message;
    HttpStatus status;
}
