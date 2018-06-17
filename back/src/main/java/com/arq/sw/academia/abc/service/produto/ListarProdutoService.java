package com.arq.sw.academia.abc.service.produto;

import com.arq.sw.academia.abc.dto.ProdutoDTO;
import com.arq.sw.academia.abc.entity.ProdutoEntity;
import com.arq.sw.academia.abc.mapper.dto.ProdutoDTOMapper;
import com.arq.sw.academia.abc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class ListarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoDTOMapper produtoMapper;


    public List<ProdutoDTO> listar() {
        List<ProdutoEntity> produtos = newArrayList(produtoRepository.findAll());
        return produtoMapper.map(produtos);
    }

}
