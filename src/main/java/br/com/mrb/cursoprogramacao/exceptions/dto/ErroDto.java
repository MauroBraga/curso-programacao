package br.com.mrb.cursoprogramacao.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErroDto {
    private String field;
    private String message;
}
