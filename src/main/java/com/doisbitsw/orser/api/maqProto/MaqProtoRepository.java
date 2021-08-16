package com.doisbitsw.orser.api.maqProto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaqProtoRepository extends JpaRepository<MaqProto, Long> {
    @Query(value = "SELECT * FROM maq_proto  ORDER BY id desc", nativeQuery = true)
    List<MaqProto> findAll();


    @Query(value = "SELECT maq.*,COUNT(maq.id) AS quant,vei.nome as nome ,vei.identificador AS identificador,vei.operador as operador,imp.nome as imple\n" +
            "FROM maq_proto maq\n" +
            "INNER JOIN veiculos vei ON vei.id = maq.maquina\n" +
            "left JOIN implementos imp ON imp.id = maq.implemento\n" +
            "where maq.protocolo = :protocolo \n" +
            "GROUP BY maq.maquina", nativeQuery = true)
    List<MaqProto> findProtocolo(Long protocolo);

    @Query(value = "select maq.*,vei.nome as nomeVei, imp.nome as nomeImp, pro.nome_usuario as nomeUser, pro.nome_localidade as nomeLocal from maq_proto maq inner join veiculos vei on vei.id = maq.maquina inner join implementos imp on imp.id = maq.implemento inner join protocolos pro on pro.id = maq.protocolo where maq.cod = :cod", nativeQuery = true)
    List<MaqProto> findCod(String cod);

    @Query(value = "SELECT maq.*, vei.nome AS nomeVei FROM maq_proto maq  INNER JOIN veiculos vei ON vei.id = maq.maquina where maq.protocolo = :protocolo", nativeQuery = true)

    List<MaqProto> findBuscaProtocolo(Long protocolo);

    @Query(value = "SELECT maq.*, COUNT(maq.id) AS quant,vei.nome as nome,vei.identificador AS identificador,vei.operador as operador,imp.nome as imple FROM maq_proto maq\n" +
            "INNER JOIN protocolos pro ON pro.id = maq.protocolo\n" +
            "INNER JOIN veiculos vei ON vei.id = maq.maquina\n" +
            "left JOIN implementos imp ON imp.id = maq.implemento\n" +
            "WHERE pro.isagendado = TRUE AND vei.isveiculo = TRUE AND  pro.setor = :setor and pro.ano = :ano\n" +
            "GROUP BY maq.maquina\n" +
            "ORDER BY quant desc", nativeQuery = true)
    List<MaqProto> findRelatorio(Long setor,Long ano);



}
