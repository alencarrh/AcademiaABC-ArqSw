package com.arq.sw.academia.abc.mapper.entity;

import com.arq.sw.academia.abc.dto.ProdutoDTO;
import com.arq.sw.academia.abc.entity.ProdutoEntity;
import com.arq.sw.academia.abc.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ProdutoEntityMapper implements Mapper<ProdutoDTO, ProdutoEntity> {

    @Autowired
    private FornecedorEntityMapper fornecedorMapper;

    @Override
    public ProdutoEntity map(ProdutoDTO from) {
        if(isNull(from)) {
            return null;
        }

        return ProdutoEntity.builder()
                            .id(from.getId())
                            .nome(from.getNome())
                            .descricao(from.getDescricao())
                            .qtdEstoque(from.getQtdEstoque())
                            .preco(from.getPreco())
                            .fornecedor(fornecedorMapper.map(from.getFornecedor()))
                            .tipo(from.getTipo())
                            .build();
    }

}
