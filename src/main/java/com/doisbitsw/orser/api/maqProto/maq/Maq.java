package com.doisbitsw.orser.api.maqProto.maq;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity(name = "maq_proto")
public class Maq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long protocolo;
    private Long implemento;
    private Long maquina;
    private String vazio;
    private String cod;
}

