package com.dev3.academia.abc.controller.matricula;

import com.dev3.academia.abc.dto.MatriculaDTO;
import com.dev3.academia.abc.dto.request.matricula.CadastrarMatriculaRequest;
import com.dev3.academia.abc.service.matricula.CadastrarMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/matricula")
public class MatriculaController implements MatriculaControllerContract {

    @Autowired
    private CadastrarMatriculaService cadastrarMatriculaService;

    @Override
    @PostMapping
    public MatriculaDTO cadastrar(@RequestBody CadastrarMatriculaRequest request) {
        return cadastrarMatriculaService.cadastrar(request);
    }

}
