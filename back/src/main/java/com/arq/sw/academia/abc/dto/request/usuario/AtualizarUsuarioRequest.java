package com.arq.sw.academia.abc.dto.request.usuario;

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
public class AtualizarUsuarioRequest implements Serializable {

    private static final long serialVersionUID = 5389485183794514152L;

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
}
