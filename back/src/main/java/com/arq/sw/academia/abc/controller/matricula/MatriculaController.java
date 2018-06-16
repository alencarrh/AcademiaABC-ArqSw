package com.arq.sw.academia.abc.controller.matricula;

import com.arq.sw.academia.abc.dto.MatriculaDTO;
import com.arq.sw.academia.abc.dto.request.matricula.CadastrarMatriculaRequest;
import com.arq.sw.academia.abc.service.matricula.CadastrarMatriculaService;
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
