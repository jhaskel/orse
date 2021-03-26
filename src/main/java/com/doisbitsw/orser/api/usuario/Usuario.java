package com.doisbitsw.orser.api.usuario;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity(name = "user")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long localidade;
    private Long entidade;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private String nivel;

    private String created;
    private String celular;
    private Boolean isativo;
    private Long setor;





}

