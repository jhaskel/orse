package com.doisbitsw.orser.api.implementos;


import com.doisbitsw.orser.api.veiculos.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImplementosRepository extends JpaRepository<Implementos, Long> {
    @Query(value = "SELECT * FROM implementos  ORDER BY id desc", nativeQuery = true)
    List<Implementos> findAll();

    @Query(value = "SELECT * FROM implementos where setor = :setor and isativo = true and isdisponivel = true  ORDER BY id desc", nativeQuery = true)
    List<Implementos> findSetor(Long setor);


    @Query(value = "SELECT * FROM implementos where entidade = :entidade and setor = :setor  ORDER BY isativo desc, isdisponivel desc,id desc", nativeQuery = true)
    List<Implementos> findEntidadeSetor(Long entidade, Long setor);

    @Query(value = "SELECT * FROM implementos where entidade = :entidade ORDER BY isativo desc, isdisponivel desc,id desc", nativeQuery = true)
    List<Implementos> findEntidade(Long entidade);




    @Query(value = "SELECT * FROM implementos where id = :id", nativeQuery = true)
    List<Implementos> findId(Long id);

    @Query(value = "select * from implementos imp\n" +
            "where imp.setor = :setor   and imp.isativo = true and imp.isdisponivel = true  and imp.id  NOT IN (SELECT implemento FROM maq_proto where cod = :nome and implemento > 0)", nativeQuery = true)
    List<Implementos> findSetorAgendado(Long setor, String nome);





}
