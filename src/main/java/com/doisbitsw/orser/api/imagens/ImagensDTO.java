package com.doisbitsw.orser.api.imagens;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ImagensDTO {
    private Long id;
    private Long protocolo;
    private String imagem;
    private Boolean isprotocolo;

    public static ImagensDTO create(Imagens imagens) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(imagens, ImagensDTO.class);
    }
}
