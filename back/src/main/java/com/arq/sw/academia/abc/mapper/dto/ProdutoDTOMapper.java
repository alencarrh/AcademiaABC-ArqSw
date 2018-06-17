package com.arq.sw.academia.abc.mapper.dto;

import com.arq.sw.academia.abc.dto.ProdutoDTO;
import com.arq.sw.academia.abc.entity.ProdutoEntity;
import com.arq.sw.academia.abc.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ProdutoDTOMapper implements Mapper<ProdutoEntity, ProdutoDTO> {

    @Autowired
    private FornecedorDTOMapper fornecedorMapper;

    @Override
    public ProdutoDTO map(ProdutoEntity from) {
        if(isNull(from)) {
            return null;
        }

        return ProdutoDTO.builder()
                         .id(from.getId())
                         .nome(from.getNome())
                         .descricao(from.getDescricao())
                         .qtdEstoque(from.getQtdEstoque())
                         .preco(from.getPreco())
                         .tipo(from.getTipo())
                         .fornecedor(fornecedorMapper.map(from.getFornecedor()))
                         .build();
    }

}
