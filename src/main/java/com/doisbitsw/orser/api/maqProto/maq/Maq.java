package com.doisbitsw.orser.api.maqProto.maq;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data
@Entity(name = "maq_proto")
public class Maq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long protocolo;
    private Long maquina;
    private String vazio ;






}

