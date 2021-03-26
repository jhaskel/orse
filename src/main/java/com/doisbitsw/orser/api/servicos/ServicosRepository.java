package com.doisbitsw.orser.api.servicos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicosRepository extends JpaRepository<Servicos, Long> {
    @Query(value = "SELECT * FROM servicos  ORDER BY id desc", nativeQuery = true)
    List<Servicos> findAll();

    @Query(value = "SELECT *  FROM servicos where entidade = :entidade ", nativeQuery = true)
    List<Servicos> findAlgo(Long entidade);


}
