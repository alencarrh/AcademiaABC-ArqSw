package com.arq.sw.academia.abc.controller.fornecedor;

import com.arq.sw.academia.abc.dto.FornecedorDTO;
import com.arq.sw.academia.abc.dto.request.fornecedor.AtualizarFornecedorRequest;
import com.arq.sw.academia.abc.dto.request.fornecedor.CadastrarFornecedorRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

public interface FornecedorControllerContract {

    @ApiOperation(
            value = "Realiza o cadastro de um novo fornecedor.",
            notes = "Retorna todos os dados do fornecedor cadastrado"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Fornecedor cadastrado com sucesso."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public FornecedorDTO cadastrar(@ApiParam(value = "Dados do fornecedor", required = true) CadastrarFornecedorRequest request);

    @ApiOperation(
            value = "Atualiza o cadastro de um fornecedor.",
            notes = "Retorna todos os dados do fornecedor atualizado"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fornecedor atualizado com sucesso."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public FornecedorDTO atualizar(@ApiParam(value = "Dados do fornecedor", required = true) AtualizarFornecedorRequest request);

    @ApiOperation(
            value = "Busca um fornecedor",
            notes = "Busca o fornecedor utilizando seu ID"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados da fornecedor"),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public FornecedorDTO consultar(@ApiParam(value = "ID do fornecedor", required = true) Long id);


    @ApiOperation(
            value = "Remove um fornecedor",
            notes = "Remover um fornecedor pelo seu ID. Não deve ter nenhum produto associado."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados do produto"),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public FornecedorDTO remover(@ApiParam(value = "ID do fornecedor", required = true) Long id);

    @ApiOperation(
            value = "Lista todos os fornecedores cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de fornecedores")
    })
    public List<FornecedorDTO> listar();
}
