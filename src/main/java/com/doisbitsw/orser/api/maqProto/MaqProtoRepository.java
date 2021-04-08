package com.doisbitsw.orser.api.maqProto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaqProtoRepository extends JpaRepository<MaqProto, Long> {
    @Query(value = "SELECT * FROM maq_proto  ORDER BY id desc", nativeQuery = true)
    List<MaqProto> findAll();


    @Query(value = "SELECT * FROM maq_proto where protocolo = :protocolo", nativeQuery = true)
    List<MaqProto> findProtocolo(Long protocolo);

    @Query(value = "SELECT maq.*, vei.nome AS nomeVei FROM maq_proto maq  INNER JOIN veiculos vei ON vei.id = maq.maquina where maq.protocolo = :protocolo", nativeQuery = true)
    List<MaqProto> findBuscaProtocolo(Long protocolo);

    @Query(value = "SELECT maq.*, COUNT(maq.id) AS quant,vei.nome as nomeVei FROM maq_proto maq\n" +
            "INNER JOIN protocolos pro ON pro.id = maq.protocolo\n" +
            "INNER JOIN veiculos vei ON vei.id = maq.maquina\n" +
            "WHERE pro.isagendado = TRUE AND vei.isveiculo = TRUE AND  pro.setor = :setor\n" +
            "GROUP BY maq.maquina\n" +
            "ORDER BY quant desc", nativeQuery = true)
    List<MaqProto> findRelatorio(Long setor);


}
