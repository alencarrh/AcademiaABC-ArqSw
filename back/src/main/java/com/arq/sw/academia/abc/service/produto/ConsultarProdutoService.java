package com.arq.sw.academia.abc.service.produto;

import com.arq.sw.academia.abc.dto.ProdutoDTO;
import com.arq.sw.academia.abc.entity.ProdutoEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.NotFoundException;
import com.arq.sw.academia.abc.mapper.dto.ProdutoDTOMapper;
import com.arq.sw.academia.abc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class ConsultarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoDTOMapper produtoMapper;

    public ProdutoDTO consultar(final Long id) {
        if(isNull(id)) {
            BadRequestException.throwNew("ID não pode ser nulo");
        }

        Optional<ProdutoEntity> opProduto = produtoRepository.findById(id);

        ProdutoEntity produto = opProduto.<NotFoundException>orElseThrow(() -> {
            throw new BadRequestException("ID não corresponde a nenhum produto.");
        });


        return produtoMapper.map(produto);
    }

}
