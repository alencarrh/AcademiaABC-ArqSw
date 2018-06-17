package com.arq.sw.academia.abc.controller.produto;

import com.arq.sw.academia.abc.dto.ProdutoDTO;
import com.arq.sw.academia.abc.dto.request.produto.AtualizarProdutoRequest;
import com.arq.sw.academia.abc.dto.request.produto.CadastrarProdutoRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ProdutoControllerContract {

    @ApiOperation(
            value = "Realiza o cadastro de um novo produto.",
            notes = "Retorna todos os dados do produto cadastrado"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Produto cadastrada com sucesso."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public ProdutoDTO cadastrar(@ApiParam(value = "Dados do produto", required = true) CadastrarProdutoRequest request);

    @ApiOperation(
            value = "Atualiza o cadastro de um produto.",
            notes = "Retorna todos os dados do produto atualizado"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto atualizado com sucesso."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public ProdutoDTO atualizar(@ApiParam(value = "Dados do produto", required = true) AtualizarProdutoRequest request);

    @ApiOperation(
            value = "Busca um produto",
            notes = "Busca o produto utilizando seu ID"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados da produto"),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public ProdutoDTO consultar(@ApiParam(value = "ID do produto", required = true) Long id);


    @ApiOperation(
            value = "Remove um produto",
            notes = "Remover um produto pelo seu ID"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados do produto"),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public ProdutoDTO remover(@ApiParam(value = "ID do produto", required = true) Long id);
}
