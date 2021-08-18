package com.doisbitsw.orser.api.protocolos.protoJoin;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity(name = "protocolos")
public class ProtoJoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuario;
    private Long localidade;
    private Long servico;
    private Long setor;
    private Long entidade;
    private Long rating;
    private String avaliacao;
    private String status;
    private String nomeUsuario;
    private String nomeLocalidade;
    private String nomeServico;
    private String content;
    private String endereco;
    private String dataAg;
    private String periodoAg;
    private String dataIn;
    private String periodoIn;
    private String dataFim;
    private String dataAval;
    private String periodoFim;
    private Long createdBy;
    private Boolean isuser;
    private Boolean isagendado;
    private Boolean isfinalizado;
    private Boolean isativo;
    private Boolean ispago;
    private Boolean ismanual;

    private Long ano;
    private Long mes;
    private Long mesAg;
    private String created;
    private String obs;
    private String modified;
    private String code;
    private Long codi;
    private String fazer;

    private Long maquina;
    private String nomeVei;








    //private Double tot;






}

