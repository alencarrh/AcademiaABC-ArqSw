package com.arq.sw.academia.abc.controller.usuario;

import com.arq.sw.academia.abc.dto.UsuarioDTO;
import com.arq.sw.academia.abc.dto.request.usuario.AtualizarUsuarioRequest;
import com.arq.sw.academia.abc.dto.request.usuario.CadastrarUsuarioRequest;
import com.arq.sw.academia.abc.service.usuario.AtualizarUsuarioService;
import com.arq.sw.academia.abc.service.usuario.CadastrarUsuarioService;
import com.arq.sw.academia.abc.service.usuario.ConsultarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioController implements UsuarioControllerContract {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    private AtualizarUsuarioService atualizarUsuarioService;

    @Autowired
    private ConsultarUsuarioService consultarUsuarioService;

    @Override
    @PostMapping
    public UsuarioDTO cadastrar(@RequestBody final CadastrarUsuarioRequest request) {
        return cadastrarUsuarioService.cadastrar(request);
    }

    @Override
    @PutMapping
    public UsuarioDTO atualizar(@RequestBody final AtualizarUsuarioRequest request) {
        return atualizarUsuarioService.atualizar(request);
    }

    @Override
    @GetMapping("/{id}")
    public UsuarioDTO consultar(@PathVariable("id") Long id) {
        return consultarUsuarioService.consultar(id);
    }

}