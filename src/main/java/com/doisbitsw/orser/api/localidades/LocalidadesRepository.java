package com.doisbitsw.orser.api.localidades;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalidadesRepository extends JpaRepository<Localidades, Long> {
    @Query(value = "SELECT * FROM localidades  ORDER BY id desc", nativeQuery = true)
    List<Localidades> findAll();


}
