package com.arq.sw.academia.abc.controller.fornecedor;

import com.arq.sw.academia.abc.dto.FornecedorDTO;
import com.arq.sw.academia.abc.dto.request.fornecedor.AtualizarFornecedorRequest;
import com.arq.sw.academia.abc.dto.request.fornecedor.CadastrarFornecedorRequest;
import com.arq.sw.academia.abc.service.fornecedor.AtualizarFornecedorService;
import com.arq.sw.academia.abc.service.fornecedor.CadastrarFornecedorService;
import com.arq.sw.academia.abc.service.fornecedor.ConsultarFornecedorService;
import com.arq.sw.academia.abc.service.fornecedor.RemoverFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/fornecedor")
public class FornecedorController implements FornecedorControllerContract {

    @Autowired
    private CadastrarFornecedorService cadastrarFornecedorService;

    @Autowired
    private AtualizarFornecedorService atualizarFornecedorService;

    @Autowired
    private ConsultarFornecedorService consultarFornecedorService;

    @Autowired
    private RemoverFornecedorService removerFornecedorService;

    @Override
    @PostMapping
    public FornecedorDTO cadastrar(@RequestBody final CadastrarFornecedorRequest request) {
        return cadastrarFornecedorService.cadastrar(request);
    }

    @Override
    @PutMapping
    public FornecedorDTO atualizar(@RequestBody final AtualizarFornecedorRequest request) {
        return atualizarFornecedorService.atualizar(request);
    }

    @Override
    @GetMapping("/{id}")
    public FornecedorDTO consultar(@PathVariable("id") Long id) {
        return consultarFornecedorService.consultar(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public FornecedorDTO remover(Long id) {
        return removerFornecedorService.remover(id);
    }
}
