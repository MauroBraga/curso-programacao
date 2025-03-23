package br.com.mrb.cursoprogramacao.modules.curso.controller;

import br.com.mrb.cursoprogramacao.modules.curso.dto.CursoRequest;
import br.com.mrb.cursoprogramacao.modules.curso.dto.CursoResponse;
import br.com.mrb.cursoprogramacao.modules.curso.entity.CursoEntity;
import br.com.mrb.cursoprogramacao.modules.curso.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CreateCursoUseCase createCursoUseCase;

    @Autowired
    private ListCursoUseCase listCursoUseCase;

    @Autowired
    private FindCursoUseCase findCursoUseCase;

    @Autowired
    private UpdateCursoUseCase updateCursoUseCase;

    @Autowired
    private DeleteCursoUseCase deleteCursoUseCase;

    @PostMapping
    public ResponseEntity create(@RequestBody CursoRequest cursoRequest) {
        try {
            var curso = this.createCursoUseCase.execute(cursoRequest);
            return ResponseEntity.ok(curso);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity list() {
        try {
            var cursos = this.listCursoUseCase.execute();
            return ResponseEntity.ok(cursos);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) {
        try {
            var cursos = this.findCursoUseCase.execute(UUID.fromString(id));
            return ResponseEntity.ok(cursos);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try {
            this.deleteCursoUseCase.execute(UUID.fromString(id));
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") String id,@RequestBody CursoRequest cursoRequest) {
        try {
            var entity = this.updateCursoUseCase.execute(UUID.fromString(id),cursoRequest);
            return ResponseEntity.ok().body(entity);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
