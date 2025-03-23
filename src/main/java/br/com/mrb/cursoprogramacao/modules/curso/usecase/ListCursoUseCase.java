package br.com.mrb.cursoprogramacao.modules.curso.usecase;

import br.com.mrb.cursoprogramacao.modules.curso.entity.CursoEntity;
import br.com.mrb.cursoprogramacao.modules.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoEntity> execute() {
        return this.cursoRepository.findAll();
    }
}
