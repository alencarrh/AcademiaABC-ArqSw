package com.dev3.academia.abc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@ToString(exclude = {"cpf"})
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "usuario",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cpf")
        }
)
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 287274812759958228L;

    private static final String seq = "id_usuario_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = seq)
    @SequenceGenerator(name = seq, sequenceName = seq)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;
}
