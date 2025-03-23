package br.com.mrb.cursoprogramacao.modules.curso.usecase;

import br.com.mrb.cursoprogramacao.enuns.Active;
import br.com.mrb.cursoprogramacao.exceptions.CursoFoundException;
import br.com.mrb.cursoprogramacao.exceptions.CursoNotFoundException;
import br.com.mrb.cursoprogramacao.modules.curso.dto.CursoRequest;
import br.com.mrb.cursoprogramacao.modules.curso.entity.CursoEntity;
import br.com.mrb.cursoprogramacao.modules.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(UUID id,CursoRequest cursoRequest) {

        this.cursoRepository.findByName(cursoRequest.getName()).ifPresent(curso -> {
            if(!id.equals(curso.getId())) {
                throw new CursoFoundException();
            }
        });

        var cursoEntity = this.cursoRepository.findById(id).orElseThrow(() -> {throw new CursoNotFoundException();});


        cursoEntity.setName(cursoRequest.getName());
        cursoEntity.setActive(Active.valueOf(cursoRequest.getActive()));
        cursoEntity.setCategory(cursoRequest.getCategory());
        return  this.cursoRepository.save(cursoEntity);
    }
}
