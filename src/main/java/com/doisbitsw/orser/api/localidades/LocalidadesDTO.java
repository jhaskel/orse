package com.doisbitsw.orser.api.localidades;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class LocalidadesDTO {
    private Long id;
    private String nome;
    private Long entidade;

    public static LocalidadesDTO create(Localidades localidades) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(localidades, LocalidadesDTO.class);
    }
}
