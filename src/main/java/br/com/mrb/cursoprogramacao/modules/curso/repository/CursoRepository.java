package br.com.mrb.cursoprogramacao.modules.curso.repository;

import br.com.mrb.cursoprogramacao.modules.curso.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, UUID> {
    Optional<CursoEntity> findByName(String name);
}
