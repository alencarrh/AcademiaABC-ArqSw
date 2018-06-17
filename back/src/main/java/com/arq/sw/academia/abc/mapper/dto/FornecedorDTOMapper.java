package com.arq.sw.academia.abc.mapper.dto;

import com.arq.sw.academia.abc.dto.FornecedorDTO;
import com.arq.sw.academia.abc.entity.FornecedorEntity;
import com.arq.sw.academia.abc.mapper.Mapper;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class FornecedorDTOMapper implements Mapper<FornecedorEntity, FornecedorDTO> {

    @Override
    public FornecedorDTO map(FornecedorEntity from) {
        if(isNull(from)) {
            return null;
        }
        return FornecedorDTO.builder()
                            .id(from.getId())
                            .nome(from.getNome())
                            .cnpj(from.getCnpj())
                            .build();
    }

}
