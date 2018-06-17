package com.arq.sw.academia.abc.entity;


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

@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "fornecedor",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cnpj")
        }
)
public class FornecedorEntity implements Serializable {

    private static final long serialVersionUID = -5547632528981675951L;

    private static final String seq = "id_fornecedor_sequence";

    @Id
    @SequenceGenerator(name = seq, sequenceName = seq, initialValue = 1)
    @GeneratedValue(generator = seq, strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cnpj;

}
