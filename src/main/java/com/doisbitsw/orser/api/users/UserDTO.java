package com.doisbitsw.orser.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
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

    private String created;
    private String celular;
    private Boolean isativo;
    private Long setor;
    // token jwt
    private String token;
    private List<String> roles;



    public static UserDTO create(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO dto = modelMapper.map(user, UserDTO.class);
        dto.roles = user.getRoles().stream()
                .map(Role::getNome)
                .collect(Collectors.toList());
        return dto;
    }

    public static UserDTO create(User user, String token) {
        UserDTO dto = create(user);
        dto.token = token;
        return dto;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    }
}
