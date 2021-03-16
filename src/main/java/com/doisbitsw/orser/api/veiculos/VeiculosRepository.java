package com.doisbitsw.orser.api.veiculos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
    @Query(value = "SELECT * FROM veiculos  ORDER BY id desc", nativeQuery = true)
    List<Veiculos> findAll();

    @Query(value = "SELECT * FROM veiculos where setor = :setor  ORDER BY id desc", nativeQuery = true)
    List<Veiculos> findSetor(Long setor);



}