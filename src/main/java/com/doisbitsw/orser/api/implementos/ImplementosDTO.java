package com.doisbitsw.orser.api.implementos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ImplementosDTO {
    private Long id;
    private Long entidade;
    private Long setor;
    private String nome;
    private String identificador;
    private Boolean isdisponivel;
    private Boolean isativo;


    public static ImplementosDTO create(Implementos maquinas) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(maquinas, ImplementosDTO.class);
    }
}
