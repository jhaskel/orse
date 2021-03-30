package com.doisbitsw.orser.api.mdo;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class MdoDTO {
    private Long id;
    private Long entidade;
    private Long setor;
    private String nome;
    private String cargo;
    private Boolean isativo;
    private Boolean isdisponivel;

    public static MdoDTO create(Mdo maquinas) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(maquinas, MdoDTO.class);
    }
}
