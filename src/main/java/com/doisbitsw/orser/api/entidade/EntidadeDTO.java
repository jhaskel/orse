package com.doisbitsw.orser.api.entidade;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EntidadeDTO {
    private Long id;
    private String nome;
    private String  cidade;
    private String  imagem;
    private String  prefeito;
    private String  sigla;
    private Boolean  isAtivo;

    public static EntidadeDTO create(Entidade entidade) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entidade, EntidadeDTO.class);
    }
}
