package com.arq.sw.academia.abc.repository;

import com.arq.sw.academia.abc.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    UsuarioEntity findByCpf(String cpf);

}
