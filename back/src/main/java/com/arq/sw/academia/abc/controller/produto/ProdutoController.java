package com.arq.sw.academia.abc.controller.produto;

import com.arq.sw.academia.abc.dto.ProdutoDTO;
import com.arq.sw.academia.abc.dto.request.produto.AtualizarProdutoRequest;
import com.arq.sw.academia.abc.dto.request.produto.CadastrarProdutoRequest;
import com.arq.sw.academia.abc.service.produto.AtualizarProdutoService;
import com.arq.sw.academia.abc.service.produto.CadastrarProdutoService;
import com.arq.sw.academia.abc.service.produto.ConsultarProdutoService;
import com.arq.sw.academia.abc.service.produto.ListarProdutoService;
import com.arq.sw.academia.abc.service.produto.RemoverProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/produto")
public class ProdutoController implements ProdutoControllerContract {

    @Autowired
    private CadastrarProdutoService cadastrarProdutoService;

    @Autowired
    private AtualizarProdutoService atualizarProdutoService;

    @Autowired
    private ConsultarProdutoService consultarProdutoService;

    @Autowired
    private RemoverProdutoService removerProdutoService;

    @Autowired
    private ListarProdutoService listarProdutoService;

    @Override
    @PostMapping
    public ProdutoDTO cadastrar(@RequestBody final CadastrarProdutoRequest request) {
        return cadastrarProdutoService.cadastrar(request);
    }

    @Override
    @PutMapping
    public ProdutoDTO atualizar(@RequestBody final AtualizarProdutoRequest request) {
        return atualizarProdutoService.atualizar(request);
    }

    @Override
    @GetMapping("/{id}")
    public ProdutoDTO consultar(@PathVariable("id") final Long id) {
        return consultarProdutoService.consultar(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public ProdutoDTO remover(@PathVariable("id") final Long id) {
        return removerProdutoService.remover(id);
    }

    @Override
    @GetMapping
    public List<ProdutoDTO> listar() {
        return listarProdutoService.listar();
    }
}
