package com.arq.sw.academia.abc.dto.request.matricula;

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
public class CadastrarMatriculaRequest implements Serializable {

    private static final long serialVersionUID = 4460566943997349307L;

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

}
