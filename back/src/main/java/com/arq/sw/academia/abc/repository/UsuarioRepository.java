package com.arq.sw.academia.abc.repository;


import com.arq.sw.academia.abc.entity.UsuarioEntity;
import org.springframework.data.repository.Repository;

public interface UsuarioRepository extends Repository<UsuarioEntity, Long> {

    UsuarioEntity save(UsuarioEntity usuario);

    UsuarioEntity findByCpf(String cpf);

}
