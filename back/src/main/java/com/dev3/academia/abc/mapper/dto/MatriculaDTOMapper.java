package com.dev3.academia.abc.mapper.dto;

import com.dev3.academia.abc.dto.MatriculaDTO;
import com.dev3.academia.abc.entity.MatriculaEntity;
import com.dev3.academia.abc.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class MatriculaDTOMapper implements Mapper<MatriculaEntity, MatriculaDTO> {

    @Autowired
    private UsuarioDTOMapper usuarioMapper;

    @Override
    public MatriculaDTO map(final MatriculaEntity from) {
        if(isNull(from)) {
            return null;
        }
        return MatriculaDTO.builder()
                           .id(from.getId())
                           .dataCadastro(from.getDataCadastro())
                           .dataCancelamento(from.getDataCancelamento())
                           .dataTrancada(from.getDataTrancada())
                           .cancelada(from.getCancelada())
                           .trancada(from.getTrancada())
                           .usuario(usuarioMapper.map(from.getUsuario()))
                           .build();
    }

}
