package com.arq.sw.academia.abc.repository;

import com.arq.sw.academia.abc.entity.MatriculaEntity;
import org.springframework.data.repository.CrudRepository;

public interface MatriculaRepository extends CrudRepository<MatriculaEntity, Long> {

    MatriculaEntity findByUsuarioCpf(String cpf);

}
