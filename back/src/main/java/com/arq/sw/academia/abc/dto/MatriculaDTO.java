package com.arq.sw.academia.abc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MatriculaDTO implements Serializable {

    private static final long serialVersionUID = 7212187810844948903L;

    private final Long id;
    private final LocalDateTime dataCadastro;
    private final Boolean cancelada;
    private final LocalDateTime dataCancelamento;
    private final Boolean bloqueada;
    private final LocalDateTime dataBloqueio;
    private final UsuarioDTO usuario;

}
