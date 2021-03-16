package com.doisbitsw.orser.api.maqProto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaqProtoRepository extends JpaRepository<MaqProto, Long> {
    @Query(value = "SELECT * FROM maq_proto  ORDER BY id desc", nativeQuery = true)
    List<MaqProto> findAll();


    @Query(value = "SELECT * FROM protocolos where protocolo = :protocolo ", nativeQuery = true)
    List<MaqProto> findProtocolo(Long protocolo);


}
