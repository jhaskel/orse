package com.doisbitsw.orser.api.implementos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImplementosRepository extends JpaRepository<Implementos, Long> {
    @Query(value = "SELECT * FROM implementos  ORDER BY id desc", nativeQuery = true)
    List<Implementos> findAll();

    @Query(value = "SELECT * FROM implementos where setor = :setor and isativo = true and isdisponivel = true  ORDER BY id desc", nativeQuery = true)
    List<Implementos> findSetor(Long setor);


    @Query(value = "SELECT * FROM implementos where entidade = :entidade and setor = :setor  ORDER BY id desc", nativeQuery = true)
    List<Implementos> findEntidade(Long entidade, Long setor);



    @Query(value = "SELECT * FROM implementos where id = :id", nativeQuery = true)
    List<Implementos> findId(Long id);





}
