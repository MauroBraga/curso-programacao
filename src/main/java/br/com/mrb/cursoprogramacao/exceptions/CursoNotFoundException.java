package br.com.mrb.cursoprogramacao.exceptions;

public class CursoNotFoundException extends RuntimeException {

    public CursoNotFoundException() {
        super("Curso  not found");
    }

    public CursoNotFoundException(String message) {
        super(message);
    }
}
