package com.doisbitsw.orser.api.veiculos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
    @Query(value = "SELECT * FROM veiculos  ORDER BY id desc", nativeQuery = true)
    List<Veiculos> findAll();

    @Query(value = "SELECT * FROM veiculos where setor = :setor and isativo = true and isdisponivel = false  ORDER BY id desc", nativeQuery = true)
    List<Veiculos> findSetor(Long setor);


    @Query(value = "SELECT * FROM veiculos where entidade = :entidade and setor = :setor  ORDER BY id desc", nativeQuery = true)
    List<Veiculos> findEntidade(Long entidade,Long setor);



    @Query(value = "SELECT * FROM veiculos where id = :id", nativeQuery = true)
    List<Veiculos> findId(Long id);





}
