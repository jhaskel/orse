package com.doisbitsw.orser.api.af;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AfDTO {
    private Long id;
    private Long code;
    private Long fornecedor;
    private String nomefornecedor;
    private Long nivel;
    private String nomenivel;
    private String created;
    private Boolean isautorizado;
    private String status;
    private Boolean ativo;
    private String pedido;
    private Double total;

    private Long totalAf;


    public static AfDTO create(Af af) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(af, AfDTO.class);
    }
}
