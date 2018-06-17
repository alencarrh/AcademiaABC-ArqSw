package com.arq.sw.academia.abc.dto.request.fornecedor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarFornecedorRequest implements Serializable {

    private static final long serialVersionUID = 5576145274931543488L;

    private Long id;
    private String nome;
}

