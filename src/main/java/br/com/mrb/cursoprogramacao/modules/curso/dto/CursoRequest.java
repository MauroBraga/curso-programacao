package br.com.mrb.cursoprogramacao.modules.curso.dto;

import lombok.Data;

@Data
public class CursoRequest {

    private String name;
    private String category;
    private String active;
}
