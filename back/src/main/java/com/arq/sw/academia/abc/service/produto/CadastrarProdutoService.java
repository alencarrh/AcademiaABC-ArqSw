package com.arq.sw.academia.abc.service.produto;

import com.arq.sw.academia.abc.dto.ProdutoDTO;
import com.arq.sw.academia.abc.dto.request.produto.CadastrarProdutoRequest;
import com.arq.sw.academia.abc.entity.FornecedorEntity;
import com.arq.sw.academia.abc.entity.ProdutoEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.PreconditionFailedException;
import com.arq.sw.academia.abc.mapper.dto.ProdutoDTOMapper;
import com.arq.sw.academia.abc.repository.FornecedorRepository;
import com.arq.sw.academia.abc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class CadastrarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ProdutoDTOMapper produtoMapper;

    public ProdutoDTO cadastrar(final CadastrarProdutoRequest request) {
        validar(request);

        Optional<FornecedorEntity> opFornecedor = fornecedorRepository.findById(request.getIdFornecedor());
        FornecedorEntity fornecedor = opFornecedor.<PreconditionFailedException>orElseThrow(() -> {
            throw new PreconditionFailedException("ID do fornecedor inválido. Nenhum forncedor com o ID " + request.getIdFornecedor());
        });

        ProdutoEntity produto = ProdutoEntity.builder()
                                             .nome(request.getNome())
                                             .descricao(request.getDescricao())
                                             .fornecedor(fornecedor)
                                             .preco(request.getPreco())
                                             .qtdEstoque(request.getQtdEstoque())
                                             .tipo(request.getTipo())
                                             .build();

        produto = produtoRepository.save(produto);

        return produtoMapper.map(produto);
    }

    private void validar(final CadastrarProdutoRequest request) {
        if(isNull(request)) {
            BadRequestException.throwNew("Request não pode ser nulo.");
        }

        if(isNull(request.getIdFornecedor())) {
            BadRequestException.throwNew("Fornecedor é obrigatório");
        }

        if(isEmpty(request.getNome())) {
            BadRequestException.throwNew("Nome do produto é obrigatório.");
        }

        if(isEmpty(request.getDescricao())) {
            BadRequestException.throwNew("Descrição Fdo produto é obrigatório.");
        }

        if(isEmpty(request.getTipo())) {
            BadRequestException.throwNew("Tipo do produto é obrigatório.");
        }

        if(isNull(request.getPreco()) || request.getPreco().compareTo(BigDecimal.ZERO) < 0) {
            BadRequestException.throwNew("Preço deve ser maior que R$ 0,00.");
        }

        if(isNull(request.getQtdEstoque()) || request.getQtdEstoque() < 0) {
            BadRequestException.throwNew("Quantidade do produto deve ser 0 ou maior.");
        }
    }
}
