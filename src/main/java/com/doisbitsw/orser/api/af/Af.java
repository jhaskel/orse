package com.doisbitsw.orser.api.af;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Af {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long code;
    private Long fornecedor;
    private String nomefornecedor;
    private Long nivel;
    private String nomenivel;
    private String created;
    private Boolean isautorizado;
    private Boolean ativo;
    private String status;
    private String pedido;
    private Double total;












}

