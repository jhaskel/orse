package com.doisbitsw.orser.api.protocolos;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class ProtocolosDTO {
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
    private String periodoAg;
    private String dataIn;
    private String periodoIn;
    private String dataFim;
    private String periodoFim;
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






    public static ProtocolosDTO create(Protocolos protocolos) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(protocolos, ProtocolosDTO.class);
    }
}
