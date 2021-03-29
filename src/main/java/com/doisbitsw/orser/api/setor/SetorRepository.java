package com.doisbitsw.orser.api.setor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Long> {
    @Query(value = "SELECT * FROM setor", nativeQuery = true)
    List<Setor> findAll();

    @Query(value = "SELECT *  FROM setor where id = :id", nativeQuery = true)
    List<Setor> findId(Long id);




}
