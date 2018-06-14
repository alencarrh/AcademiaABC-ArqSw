package com.dev3.academia.abc.fixture.dto.request.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarUsuarioRequest implements Serializable {

    private static final long serialVersionUID = -1077570237780501324L;

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

}
