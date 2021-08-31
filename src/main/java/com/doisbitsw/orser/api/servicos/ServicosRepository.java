package com.doisbitsw.orser.api.servicos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicosRepository extends JpaRepository<Servicos, Long> {
    @Query(value = "SELECT ser.*, FROM servicos ser  ORDER BY ser.nome desc", nativeQuery = true)
    List<Servicos> findAll();

    /*@Query(value = "SELECT ser.*,count(ser.id) as quant, ent.cidade AS nomec FROM servicos ser\n" +
            "INNER JOIN entidade ent ON ent.id = ser.entidade\n" +
            "where ser.entidade = :entidade and ser.setor = :setor\n" +
            "GROUP BY ser.id ORDER BY ser.id desc ", nativeQuery = true)
    List<Servicos> findEntidadeSetor(Long entidade,Long setor);*/

    @Query(value = "SELECT * FROM servicos where entidade = :entidade and setor = :setor ORDER BY nome desc ", nativeQuery = true)
    List<Servicos> findEntidadeSetor(Long entidade,Long setor);

    @Query(value = "SELECT * FROM servicos where entidade = :entidade and ispublic = true ORDER BY nome desc ", nativeQuery = true)
    List<Servicos> findPublico(Long entidade);

    @Query(value = "SELECT ismanual FROM servicos WHERE id = :id ", nativeQuery = true)
    boolean findTipo(Long id);



}
