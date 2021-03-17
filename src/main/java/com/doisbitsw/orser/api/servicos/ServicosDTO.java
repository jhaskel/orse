package com.doisbitsw.orser.api.servicos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ServicosDTO {
    private Long id;
    private String nome;
    private String unidade;
    private Boolean ispago;
    private Boolean ismanual;
    private Double valor;
    private Long entidade;
    private Long setor;

    public static ServicosDTO create(Servicos servicos) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(servicos, ServicosDTO.class);
    }
}
