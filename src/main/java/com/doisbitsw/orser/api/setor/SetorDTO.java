package com.doisbitsw.orser.api.setor;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class SetorDTO {
    private Long id;
    private String nome;
    private String responsavel;
    private String cargo;
    private Long entidade;

    public static SetorDTO create(Setor setor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(setor, SetorDTO.class);
    }
}
