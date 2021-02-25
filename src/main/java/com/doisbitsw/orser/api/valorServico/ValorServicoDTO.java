package com.doisbitsw.orser.api.valorServico;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ValorServicoDTO {
    private Long id;
    private Long servico;
    private Double valor;

    public static ValorServicoDTO create(ValorServico valorServico) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(valorServico, ValorServicoDTO.class);
    }
}
