package com.doisbitsw.orser.api.valorServico;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ValorServicoRepository extends JpaRepository<ValorServico, Long> {
    @Query(value = "SELECT * FROM valor_servico  ORDER BY id desc", nativeQuery = true)
    List<ValorServico> findAll();


}
