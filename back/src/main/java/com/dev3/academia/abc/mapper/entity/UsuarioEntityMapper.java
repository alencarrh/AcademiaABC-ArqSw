package com.dev3.academia.abc.mapper.entity;

import com.dev3.academia.abc.dto.UsuarioDTO;
import com.dev3.academia.abc.entity.UsuarioEntity;
import com.dev3.academia.abc.mapper.Mapper;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class UsuarioEntityMapper implements Mapper<UsuarioDTO, UsuarioEntity> {

    @Override
    public UsuarioEntity map(UsuarioDTO from) {
        if(isNull(from)) {
            return null;
        }
        return UsuarioEntity.builder()
                            .id(from.getId())
                            .nome(from.getNome())
                            .cpf(from.getCpf())
                            .dataNascimento(from.getDataNascimento())
                            .build();
    }

}
