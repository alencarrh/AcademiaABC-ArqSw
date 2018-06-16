package com.arq.sw.academia.abc.mapper.entity;

import com.arq.sw.academia.abc.dto.MatriculaDTO;
import com.arq.sw.academia.abc.entity.MatriculaEntity;
import com.arq.sw.academia.abc.mapper.Mapper;
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
                              .dataBloqueio(from.getDataBloqueio())
                              .cancelada(from.getCancelada())
                              .bloqueada(from.getBloqueada())
                              .usuario(usuarioMapper.map(from.getUsuario()))
                              .build();
    }

}
