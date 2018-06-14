package com.dev3.academia.abc.repository;

import com.dev3.academia.abc.entity.UsuarioEntity;
import org.springframework.data.repository.Repository;

public interface UsuarioRepository extends Repository<UsuarioEntity, Long> {

    UsuarioEntity save(UsuarioEntity usuario);

    UsuarioEntity findByCpf(String cpf);

}
