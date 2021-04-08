package com.doisbitsw.orser.api.maqProto;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class MaqProtoDTO {
    private Long id;
    private Long protocolo;
    private Long maquina;
    private String vazio;

    private String nome;
    private Long quant;



    public static MaqProtoDTO create(MaqProto maqProto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(maqProto, MaqProtoDTO.class);
    }
}
