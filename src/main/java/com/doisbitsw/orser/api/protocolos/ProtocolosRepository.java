package com.doisbitsw.orser.api.protocolos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProtocolosRepository extends JpaRepository<Protocolos, Long> {
    @Query(value = "SELECT * FROM protocolos  ORDER BY id ", nativeQuery = true)
    List<Protocolos> findAll();

    @Query(value = "SELECT *  FROM protocolos where isativo = true and entidade = :entidade and ano =:ano order by id desc ", nativeQuery = true)
    List<Protocolos> findAtivo(Long entidade, Long ano);


}
