package com.arq.sw.academia.abc.controller.usuario;

import com.arq.sw.academia.abc.dto.UsuarioDTO;
import com.arq.sw.academia.abc.dto.request.usuario.AtualizarUsuarioRequest;
import com.arq.sw.academia.abc.dto.request.usuario.CadastrarUsuarioRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface UsuarioControllerContract {

    @ApiOperation(
            value = "Realiza o cadastro de um novo usuário.",
            notes = "Retorna todos os dados do usuário cadastrado"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuário cadastrado com sucesso."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public UsuarioDTO cadastrar(@ApiParam(value = "Dados do usuário", required = true) CadastrarUsuarioRequest request);

    @ApiOperation(
            value = "Atualiza o cadastro de um usuário.",
            notes = "Retorna todos os dados do usuário atualizado"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário atualizado com sucesso."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public UsuarioDTO atualizar(@ApiParam(value = "Dados do usuário", required = true) AtualizarUsuarioRequest request);

    @ApiOperation(
            value = "Busca um usuário",
            notes = "Busca o usuário utilizando seu ID"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados da usuário"),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public UsuarioDTO consultar(@ApiParam(value = "ID do usuário", required = true) Long id);

}
