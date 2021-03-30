package com.doisbitsw.orser.api.mdo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Mdo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long entidade;
    private Long setor;
    private String nome;
    private String cargo;
    private Boolean isativo;
    private Boolean isdisponivel;

}

