package com.dev3.academia.abc.repository;

import com.dev3.academia.abc.entity.MatriculaEntity;
import org.springframework.data.repository.Repository;

public interface MatriculaRepository extends Repository<MatriculaEntity, Long> {

    MatriculaEntity save(MatriculaEntity matricula);

}
