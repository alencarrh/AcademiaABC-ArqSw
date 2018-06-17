package com.arq.sw.academia.abc.dto.request.produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarProdutoRequest implements Serializable {

    private static final long serialVersionUID = 192577609178332023L;

    private Long id;
    private Long idFornecedor;
    private String nome;
    private String descricao;
    private String tipo;
    private Integer qtdEstoque;
    private BigDecimal preco;
}
