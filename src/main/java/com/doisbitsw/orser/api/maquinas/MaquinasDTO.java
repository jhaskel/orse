package com.doisbitsw.orser.api.maquinas;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class MaquinasDTO {
    private Long id;
    private String nome;
    private Long entidade;

    public static MaquinasDTO create(Maquinas maquinas) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(maquinas, MaquinasDTO.class);
    }
}
