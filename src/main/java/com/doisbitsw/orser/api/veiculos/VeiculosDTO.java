package com.doisbitsw.orser.api.veiculos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class VeiculosDTO {
    private Long id;
    private Long entidade;
    private Long setor;
    private String nome;
    private String identificador;
    private String operador;
    private Boolean isdisponivel;
    private Boolean isativo;
    private Boolean isveiculo;


    public static VeiculosDTO create(Veiculos maquinas) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(maquinas, VeiculosDTO.class);
    }
}
