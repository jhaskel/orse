package com.doisbitsw.orser.api.maqProto.maq;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class MaqDTO {
    private Long id;
    private Long protocolo;
    private Long implemento;
    private Long maquina;
    private List<String> vazio ;


    public static MaqDTO create(Maq maq) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(maq, MaqDTO.class);
    }
}
