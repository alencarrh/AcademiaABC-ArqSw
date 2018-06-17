package com.arq.sw.academia.abc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class FornecedorDTO implements Serializable {

    private static final long serialVersionUID = -6982099608542786755L;

    private Long id;
    private String nome;
    private String cnpj;

}
