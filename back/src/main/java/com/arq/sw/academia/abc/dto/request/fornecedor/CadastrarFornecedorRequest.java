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
public class CadastrarFornecedorRequest implements Serializable {

    private static final long serialVersionUID = -5476331108116724786L;

    private String nome;
    private String cnpj;
}
