package com.doisbitsw.orser.api.veiculos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long entidade;
    private Long setor;
    private String nome;
    private String identificador;
    private String operador;
    private Boolean isdisponivel;
    private Boolean isativo;
    private Boolean isveiculo;

}

