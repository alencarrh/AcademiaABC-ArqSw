package com.arq.sw.academia.abc.controller.matricula;

import com.arq.sw.academia.abc.dto.MatriculaDTO;
import com.arq.sw.academia.abc.dto.request.matricula.CadastrarMatriculaRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface MatriculaControllerContract {

    @ApiOperation(
            value = "Realiza o cadastro de uma nova matrícula.",
            notes = "Os dados obrigatórios de usuário também são obrigatórios para a matrícula pois será criado o usuário caso não exista."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Matrícula cadastrada com sucesso."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public MatriculaDTO cadastrar(@ApiParam(value = "Dados da matrícula", required = true) CadastrarMatriculaRequest request);

    @ApiOperation(
            value = "Busca os dados de matrícula do cliente",
            notes = "Busca utilizando o CPF."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Dados da matrícula"),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public MatriculaDTO consultar(@ApiParam(value = "CPF do cliente", required = true) String cpf);

    @ApiOperation(
            value = "Efetua o (des)cancelamento da matrícula do cliente.",
            notes = "Caso a matricula já esteja cancelada, faz o descancelamento."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Matrícula (des)cancelada com sucesso."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public void cancelar(@ApiParam(value = "CPF do cliente", required = true) String cpf);

    @ApiOperation(
            value = "Bloqueia a matrícula do cliente.",
            notes = "Caso a matrícula do cliente já esteja bloqueada faz o desbloqueio."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Matrícula (des)bloqueada com sucesso."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public void bloquear(@ApiParam(value = "CPF do cliente", required = true) String cpf);
}
