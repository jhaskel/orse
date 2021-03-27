package com.doisbitsw.orser.api.servicos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String unidade;
    private Boolean ispago;
    private Boolean ismanual;
    private Double valor;
    private Long entidade;
    private Long setor;

    private Long quant;
    private String nomec;


}

