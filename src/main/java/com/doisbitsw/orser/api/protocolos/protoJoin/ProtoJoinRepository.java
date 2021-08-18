package com.doisbitsw.orser.api.protocolos.protoJoin;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProtoJoinRepository extends JpaRepository<ProtoJoin, Long> {
    @Query(value = "SELECT * FROM protocolos  ORDER BY id ", nativeQuery = true)
    List<ProtoJoin> findAll();

    @Query(value = "SELECT *  FROM protocolos where entidade = :entidade and ano = :ano and setor=:setor   order by id desc   ", nativeQuery = true)
    List<ProtoJoin> findAtivo(Long entidade, Long ano, Long setor);

    @Query(value = "SELECT *  FROM protocolos where entidade = :entidade and ano = :ano  order by id desc   ", nativeQuery = true)
    List<ProtoJoin> findProto(Long entidade, Long ano);

    @Query(value = "select pro.*\n" +
            "from protocolos pro\n" +
            "left join maq_proto maq on maq.protocolo = pro.id\n" +
            "left join veiculos vei on vei.id = maq.maquina\n" +
            "where maq.maquina = :entidade and ano = :ano and pro.ismanual = true\n" +
            "group by pro.id", nativeQuery = true)
    List<ProtoJoin> findProtoMaq(Long entidade, Long ano);


    @Query(value = "SELECT *  FROM protocolos where entidade = :entidade and ano = :ano and setor=:setor and isagendado = true  order by data_ag   ", nativeQuery = true)
    List<ProtoJoin> findAgendado(Long entidade, Long ano, Long setor);

    @Query(value = "SELECT *  FROM protocolos where entidade = :entidade and ano = :ano and setor=:setor and isagendado = true and mes = :mes order by data_ag   ", nativeQuery = true)
    List<ProtoJoin> findAgendadoMes(Long entidade, Long ano, Long mes, Long setor);

    @Query(value = "SELECT * FROM protocolos where entidade = :entidade and usuario = :usuario order by id desc   ", nativeQuery = true)
    List<ProtoJoin> findUser(Long entidade, Long usuario);

    @Query(value = "SELECT codi FROM protocolos WHERE entidade = :entidade ORDER BY codi DESC LIMIT 1 ", nativeQuery = true)
    long findCode(Long entidade);

}
