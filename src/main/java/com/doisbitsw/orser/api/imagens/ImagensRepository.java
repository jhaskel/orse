package com.doisbitsw.orser.api.imagens;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImagensRepository extends JpaRepository<Imagens, Long> {
    @Query(value = "SELECT * FROM imagens  ORDER BY id desc", nativeQuery = true)
    List<Imagens> findAll();

    @Query(value = "SELECT *  FROM imagens where protocolo = :protocolo ", nativeQuery = true)
    List<Imagens> findProtocolo(Long protocolo);


}
