package com.arq.sw.academia.abc.service.fornecedor;

import com.arq.sw.academia.abc.dto.FornecedorDTO;
import com.arq.sw.academia.abc.entity.FornecedorEntity;
import com.arq.sw.academia.abc.entity.ProdutoEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.NotFoundException;
import com.arq.sw.academia.abc.exception.status.PreconditionFailedException;
import com.arq.sw.academia.abc.mapper.dto.FornecedorDTOMapper;
import com.arq.sw.academia.abc.repository.FornecedorRepository;
import com.arq.sw.academia.abc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.hibernate.internal.util.collections.CollectionHelper.isNotEmpty;

@Service
public class RemoverFornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorDTOMapper fornecedorMapper;

    public FornecedorDTO remover(final Long id) {
        if(isNull(id)) {
            BadRequestException.throwNew("ID não pode ser nulo.");
        }
        Optional<FornecedorEntity> opFornecedor = fornecedorRepository.findById(id);

        FornecedorEntity fornecedor = opFornecedor.<NotFoundException>orElseThrow(() -> {
            throw new NotFoundException("ID não corresponde a nenhum fornecedor.");
        });

        List<ProdutoEntity> produtos = produtoRepository.findByFornecedorId(fornecedor.getId());

        if(isNotEmpty(produtos)) {
            PreconditionFailedException.throwNew("Fornecedor não pode ser removido pois existem produtos vinculados a este.");
        }

        fornecedorRepository.delete(fornecedor);

        return fornecedorMapper.map(fornecedor);
    }

}
