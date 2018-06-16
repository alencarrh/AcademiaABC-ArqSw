package com.arq.sw.academia.abc.mapper.entity;


import com.arq.sw.academia.abc.dto.UsuarioDTO;
import com.arq.sw.academia.abc.entity.UsuarioEntity;
import com.arq.sw.academia.abc.mapper.Mapper;
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
