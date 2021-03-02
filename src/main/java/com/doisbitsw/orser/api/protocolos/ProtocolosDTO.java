package com.doisbitsw.orser.api.protocolos;

import lombok.Data;
import org.modelmapper.ModelMapper;

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
    public static ProtocolosDTO create(Protocolos protocolos) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(protocolos, ProtocolosDTO.class);
    }
}
