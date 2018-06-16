package com.arq.sw.academia.abc.repository;

import com.arq.sw.academia.abc.entity.MatriculaEntity;
import org.springframework.data.repository.Repository;

public interface MatriculaRepository extends Repository<MatriculaEntity, Long> {

    MatriculaEntity save(MatriculaEntity matricula);

}
