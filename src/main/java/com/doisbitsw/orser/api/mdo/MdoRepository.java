package com.doisbitsw.orser.api.mdo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MdoRepository extends JpaRepository<Mdo, Long> {
    @Query(value = "SELECT * FROM mdo  ORDER BY id desc", nativeQuery = true)
    List<Mdo> findAll();

    @Query(value = "SELECT * FROM mdo where setor = :setor and isativo = true and isdisponivel = true  ORDER BY id desc", nativeQuery = true)
    List<Mdo> findSetor(Long setor);


    @Query(value = "SELECT * FROM mdo where id = :id", nativeQuery = true)
    List<Mdo> findId(Long id);


    @Query(value = "SELECT * FROM mdo where entidade = :entidade and setor = :setor  ORDER BY id desc", nativeQuery = true)
    List<Mdo> findEntidade(Long entidade,Long setor);





}
