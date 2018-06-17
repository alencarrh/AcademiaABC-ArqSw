package com.arq.sw.academia.abc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 8644157639937025627L;

    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private Integer qtdEstoque;
    private BigDecimal preco;
    private FornecedorDTO fornecedor;

}
