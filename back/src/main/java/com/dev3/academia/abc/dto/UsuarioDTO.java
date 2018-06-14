package com.dev3.academia.abc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = -1661550166674389185L;

    private final Long id;
    private final String nome;
    private final String cpf;
    private final LocalDate dataNascimento;

}
