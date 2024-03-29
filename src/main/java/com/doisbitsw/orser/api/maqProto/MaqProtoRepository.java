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

    @Query(value = "SELECT maq.*,COUNT(maq.id) AS quant,vei.nome as nome ,pro.nome_usuario AS identificador,pro.nome_localidade as operador,imp.nome as imple\n" +
            "FROM maq_proto maq\n" +
            "INNER JOIN veiculos vei ON vei.id = maq.maquina\n" +
            "left JOIN implementos imp ON imp.id = maq.implemento\n" +
            "INNER JOIN protocolos pro ON pro.id = maq.protocolo\n" +
            "where maq.cod = :cod \n" +
            "GROUP BY maq.maquina", nativeQuery = true)
    List<MaqProto> findCod(String cod);

    @Query(value = "SELECT maq.*,COUNT(maq.id) AS quant,vei.nome as nome ,vei.identificador AS identificador,vei.nome as operador,vei.nome as imple\n" +
            "FROM maq_proto maq\n" +
            "INNER JOIN veiculos vei ON vei.id = maq.maquina\n" +
            "INNER JOIN protocolos pro ON pro.id = maq.protocolo\n" +
            "where vei.entidade = :entidade and pro.ismanual=false\n" +
            "GROUP BY maq.maquina", nativeQuery = true)
    List<MaqProto> findMaqServicos(Long entidade);

    @Query(value = "SELECT maq.*,COUNT(maq.id) AS quant,pro.nome_usuario as nome ,pro.nome_servico AS identificador,pro.nome_localidade as operador,pro.status as imple           \n" +
            "from maq_proto maq \n" +
            "inner join protocolos pro on pro.id = maq.protocolo\n" +
            "where maq.maquina = :maquina and pro.cod_ag = :vazio  and pro.periodo_ag = :cod and (pro.status='Agendado' or pro.status = 'Iniciado')\n" +
            "group by maq.id", nativeQuery = true)
    List<MaqProto> findMaquina(Long maquina,String cod,String vazio);




    @Query(value = "SELECT maq.*, COUNT(maq.id) AS quant,vei.nome AS nomeVei FROM maq_proto maq  INNER JOIN veiculos vei ON vei.id = maq.maquina where maq.protocolo = :protocolo", nativeQuery = true)

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
