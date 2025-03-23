package br.com.mrb.cursoprogramacao.modules.curso.usecase;

import br.com.mrb.cursoprogramacao.exceptions.CursoNotFoundException;
import br.com.mrb.cursoprogramacao.modules.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public void execute(UUID cursoId) {
        var cursoEntity = this.cursoRepository.findById(cursoId).orElseThrow(() -> {throw new CursoNotFoundException();});
        this.cursoRepository.delete(cursoEntity);
    }
}
