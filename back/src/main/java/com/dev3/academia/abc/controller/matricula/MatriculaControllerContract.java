package com.dev3.academia.abc.controller.matricula;

import com.dev3.academia.abc.dto.MatriculaDTO;
import com.dev3.academia.abc.dto.request.matricula.CadastrarMatriculaRequest;
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

}
