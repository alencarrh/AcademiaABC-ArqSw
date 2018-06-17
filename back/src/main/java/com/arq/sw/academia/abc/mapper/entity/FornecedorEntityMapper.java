package com.arq.sw.academia.abc.mapper.entity;

import com.arq.sw.academia.abc.dto.FornecedorDTO;
import com.arq.sw.academia.abc.entity.FornecedorEntity;
import com.arq.sw.academia.abc.mapper.Mapper;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class FornecedorEntityMapper implements Mapper<FornecedorDTO, FornecedorEntity> {

    @Override
    public FornecedorEntity map(FornecedorDTO from) {
        if(isNull(from)) {
            return null;
        }
        return FornecedorEntity.builder()
                               .id(from.getId())
                               .nome(from.getNome())
                               .cnpj(from.getCnpj())
                               .build();
    }

}
