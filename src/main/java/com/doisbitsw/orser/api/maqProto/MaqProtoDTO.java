package com.doisbitsw.orser.api.maqProto;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class MaqProtoDTO {
    private Long id;
    private Long protocolo;
    private Long maquina;
    private List<String> vazio;

    private String nome;
    private Long quant;
    private String identificador;



    public static MaqProtoDTO create(MaqProto maqProto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(maqProto, MaqProtoDTO.class);
    }
}
