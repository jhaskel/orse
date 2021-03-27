package com.doisbitsw.orser.api.servicos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicosRepository extends JpaRepository<Servicos, Long> {


    @Query(value = "SELECT ser.*,count(ser.id) as quant, ent.cidade AS nomeCidade FROM servicos ser\n" +
            "INNER JOIN entidade ent ON ent.id = ser.entidade\n" +
            "where ser.entidade = 1 ", nativeQuery = true)
    List<Servicos> findAlgo(Long entidade);


}
