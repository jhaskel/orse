package com.doisbitsw.orser.api.maquinas;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaquinasRepository extends JpaRepository<Maquinas, Long> {
    @Query(value = "SELECT * FROM maquinas  ORDER BY id desc", nativeQuery = true)
    List<Maquinas> findAll();


}
