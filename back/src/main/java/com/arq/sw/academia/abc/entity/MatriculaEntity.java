package com.arq.sw.academia.abc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "matricula")
public class MatriculaEntity implements Serializable {

    private static final long serialVersionUID = 1900977867290410448L;

    private static final String seq = "id_matricula_sequence";

    @Id
    @SequenceGenerator(name = seq, sequenceName = seq, initialValue = 1)
    @GeneratedValue(generator = seq, strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    private Boolean cancelada;

    @Column(nullable = false)
    private Boolean bloqueada;

    @Column
    private LocalDateTime dataCancelamento;

    @Column
    private LocalDateTime dataBloqueio;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    public static MatriculaEntity newMatricula(final UsuarioEntity usuario) {
        return MatriculaEntity.builder()
                              .usuario(usuario)
                              .dataCadastro(LocalDateTime.now())
                              .bloqueada(Boolean.FALSE)
                              .cancelada(Boolean.FALSE)
                              .build();
    }
}
