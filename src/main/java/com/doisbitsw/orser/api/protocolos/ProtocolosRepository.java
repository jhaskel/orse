package com.doisbitsw.orser.api.protocolos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProtocolosRepository extends JpaRepository<Protocolos, Long> {
    @Query(value = "SELECT * FROM protocolos  ORDER BY id ", nativeQuery = true)
    List<Protocolos> findAll();

    @Query(value = "SELECT *  FROM protocolos where entidade = :entidade and ano = :ano and setor=:setor  order by id desc   ", nativeQuery = true)
    List<Protocolos> findAtivo(Long entidade, Long ano,Long setor);

    @Query(value = "SELECT *  FROM protocolos where entidade = :entidade and ano = :ano and setor=:setor and isagendado = true  order by data_ag   ", nativeQuery = true)
    List<Protocolos> findAgendado(Long entidade,Long ano,Long setor);

    @Query(value = "SELECT *  FROM protocolos where entidade = :entidade and ano = :ano and setor=:setor and isagendado = true and mes = :mes order by data_ag   ", nativeQuery = true)
    List<Protocolos> findAgendadoMes(Long entidade,Long ano,Long mes,Long setor);


    @Query(value = "SELECT codi FROM protocolos WHERE entidade = :entidade ORDER BY codi DESC LIMIT 1 ", nativeQuery = true)
    long findCode(Long entidade);


}
