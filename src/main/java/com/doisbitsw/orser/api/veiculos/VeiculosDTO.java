package com.doisbitsw.orser.api.veiculos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class VeiculosDTO {
    private Long id;
    private Long setor;
    private String nome;
    private String placa;
    private Long entidade;
    private Boolean ismanutencao;
    private Boolean isativo;


    public static VeiculosDTO create(Veiculos maquinas) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(maquinas, VeiculosDTO.class);
    }
}
