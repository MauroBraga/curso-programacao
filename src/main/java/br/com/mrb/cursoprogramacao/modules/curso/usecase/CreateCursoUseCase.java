package br.com.mrb.cursoprogramacao.modules.curso.usecase;

import br.com.mrb.cursoprogramacao.enuns.Active;
import br.com.mrb.cursoprogramacao.exceptions.CursoFoundException;
import br.com.mrb.cursoprogramacao.modules.curso.dto.CursoRequest;
import br.com.mrb.cursoprogramacao.modules.curso.dto.CursoResponse;
import br.com.mrb.cursoprogramacao.modules.curso.entity.CursoEntity;
import br.com.mrb.cursoprogramacao.modules.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoResponse execute(CursoRequest cursoRequest) {

        this.cursoRepository.findByName(cursoRequest.getName()).ifPresent(curso -> {
            throw new CursoFoundException();
        });
        var curso = new CursoEntity();
        curso.setName(cursoRequest.getName());
        curso.setActive(Active.valueOf(cursoRequest.getActive()));
        curso.setCategory(cursoRequest.getCategory());
        var entity =  this.cursoRepository.save(curso);
        return CursoResponse.builder().name(entity.getName()).active(entity.getActive().name()).category(entity.getCategory()).build();
    }
}
