package com.doisbitsw.orser.api.maqProto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaqProtoRepository extends JpaRepository<MaqProto, Long> {
    @Query(value = "SELECT * FROM maq_proto  ORDER BY id desc", nativeQuery = true)
    List<MaqProto> findAll();


    @Query(value = "SELECT maq.* FROM maq_proto maq where maq.protocolo = :protocolo ", nativeQuery = true)
    List<MaqProto> findProtocolo(Long protocolo);

    @Query(value = "SELECT maq.*, vei.nome as nomeVei,vei.placa  AS placaVei FROM maq_proto maq\n" +
            "INNER JOIN veiculos vei ON vei.id = maq.maquina\n" +
            "WHERE maq.protocolo= :protocolo ", nativeQuery = true)
    List<MaqProto> findBuscaProtocolo(Long protocolo);


}
