package com.doisbitsw.orser.api.protocolos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Protocolos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuario;
    private Long localidade;
    private Long servico;
    private Long setor;
    private Long entidade;
    private String status;
    private String nomeUsuario;
    private String nomeLocalidade;
    private String nomeServico;
    private String content;
    private String endereco;
    private String dataAg;
    private String horaAg;
    private String dataIn;
    private String horaIn;
    private String dataFim;
    private String horaFim;
    private Boolean isuser;
    private Boolean isagendado;
    private Boolean isfinalizado;
    private Boolean isativo;
    private Boolean ispago;
    private Long ano;
    private Long mes;
    private String created;






}

