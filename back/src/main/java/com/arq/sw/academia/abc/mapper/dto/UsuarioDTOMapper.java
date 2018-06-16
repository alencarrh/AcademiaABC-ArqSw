package com.arq.sw.academia.abc.mapper.dto;

import com.arq.sw.academia.abc.dto.UsuarioDTO;
import com.arq.sw.academia.abc.entity.UsuarioEntity;
import com.arq.sw.academia.abc.mapper.Mapper;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class UsuarioDTOMapper implements Mapper<UsuarioEntity, UsuarioDTO> {

    @Override
    public UsuarioDTO map(UsuarioEntity from) {
        if(isNull(from)) {
            return null;
        }
        return UsuarioDTO.builder()
                         .id(from.getId())
                         .nome(from.getNome())
                         .cpf(from.getCpf())
                         .dataNascimento(from.getDataNascimento())
                         .build();
    }

}
