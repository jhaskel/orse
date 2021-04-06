package com.doisbitsw.orser.api.entidade;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntidadeRepository extends JpaRepository<Entidade, Long> {
    @Query(value = "SELECT * FROM entidade  ORDER BY id desc", nativeQuery = true)
    List<Entidade> findAll();

    @Query(value = "SELECT * FROM entidade where id = :id", nativeQuery = true)
    List<Entidade> findEntidade(Long id);


}
