package com.dev3.academia.abc.mapper.dto;

import com.dev3.academia.abc.dto.UsuarioDTO;
import com.dev3.academia.abc.entity.UsuarioEntity;
import com.dev3.academia.abc.mapper.Mapper;
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
