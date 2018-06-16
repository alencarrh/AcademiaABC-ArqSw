package com.arq.sw.academia.abc.controller.matricula;

import com.arq.sw.academia.abc.dto.MatriculaDTO;
import com.arq.sw.academia.abc.dto.request.matricula.CadastrarMatriculaRequest;
import com.arq.sw.academia.abc.service.matricula.ConsultarMatriculaService;
import com.arq.sw.academia.abc.service.matricula.ToggleBloqueioMatriculaService;
import com.arq.sw.academia.abc.service.matricula.CadastrarMatriculaService;
import com.arq.sw.academia.abc.service.matricula.ToggleCancelamentoMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/matricula")
public class MatriculaController implements MatriculaControllerContract {

    @Autowired
    private CadastrarMatriculaService cadastrarMatriculaService;

    @Autowired
    private ConsultarMatriculaService consultarMatriculaService;

    @Autowired
    private ToggleCancelamentoMatriculaService toggleCancelamentoMatriculaService;

    @Autowired
    private ToggleBloqueioMatriculaService toggleBloqueioMatriculaService;

    @Override
    @PostMapping
    public MatriculaDTO cadastrar(@RequestBody final CadastrarMatriculaRequest request) {
        return cadastrarMatriculaService.cadastrar(request);
    }

    @Override
    @GetMapping("/{cpf}")
    public MatriculaDTO consultar(@PathVariable("cpf") final String cpf) {
        return consultarMatriculaService.consultar(cpf);
    }

    @Override
    @PostMapping("{cpf}/cancelar")
    public void cancelar(@PathVariable("cpf") final String cpf) {
        toggleCancelamentoMatriculaService.toggleCancelamento(cpf);
    }

    @Override
    @PostMapping("{cpf}/bloquear")
    public void bloquear(@PathVariable("cpf") final String cpf) {
        toggleBloqueioMatriculaService.toogleBloqueio(cpf);
    }

}
