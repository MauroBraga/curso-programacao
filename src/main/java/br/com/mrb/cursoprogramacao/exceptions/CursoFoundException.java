package br.com.mrb.cursoprogramacao.exceptions;

public class CursoFoundException  extends RuntimeException {

    public CursoFoundException() {
        super("Curso  already exists");
    }

    public CursoFoundException(String message) {
        super(message);
    }
}
