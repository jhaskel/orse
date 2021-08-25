package com.doisbitsw.orser.api.protocolos.protoJoin;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProtoJoinDTO {
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
    private String codi;
    private String fazer;
    private String codAg;

    private Long maquina;
    private String nomevei;






    public static ProtoJoinDTO create(ProtoJoin protoJoin) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(protoJoin, ProtoJoinDTO.class);
    }
}
