package com.dev3.academia.abc.mapper.entity;

import com.dev3.academia.abc.dto.MatriculaDTO;
import com.dev3.academia.abc.entity.MatriculaEntity;
import com.dev3.academia.abc.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class MatriculaEntityMapper implements Mapper<MatriculaDTO, MatriculaEntity> {

    @Autowired
    private UsuarioEntityMapper usuarioMapper;

    @Override
    public MatriculaEntity map(final MatriculaDTO from) {
        if(isNull(from)) {
            return null;
        }
        return MatriculaEntity.builder()
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
