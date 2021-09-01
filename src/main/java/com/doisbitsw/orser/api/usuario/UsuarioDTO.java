package com.doisbitsw.orser.api.usuario;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class UsuarioDTO {
    private Long id;
    private Long localidade;
    private Long entidade;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private String nivel;
    private Boolean receberemail;
    private String cod;

    private String created;
    private String celular;
    private Boolean isativo;
    private Long setor;



    public static UsuarioDTO create(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
}
