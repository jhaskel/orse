package com.doisbitsw.orser.api.veiculos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
    @Query(value = "SELECT * FROM veiculos  ORDER BY id desc", nativeQuery = true)
    List<Veiculos> findAll();

    @Query(value = "SELECT * FROM veiculos where setor = :setor and isativo = true and isdisponivel = true  ORDER BY id desc", nativeQuery = true)
    List<Veiculos> findSetor(Long setor);

    @Query(value = "SELECT * FROM veiculos where entidade = :entidade and setor = :setor  ORDER BY isativo desc,isdisponivel desc,id desc", nativeQuery = true)
    List<Veiculos> findEntidadeSetor(Long entidade,Long setor);

    @Query(value = "select * from veiculos vei\n" +
            "where vei.setor = :setor and vei.isveiculo = true and vei.isativo = true and vei.isdisponivel = true and and vei.id NOT IN (SELECT maquina FROM maq_proto where cod = :operador)", nativeQuery = true)
    List<Veiculos> findSetorAgendado(Long setor,String operador);

    @Query(value = "SELECT * FROM veiculos where entidade = :entidade   ORDER BY isativo desc,isdisponivel desc,id desc", nativeQuery = true)
    List<Veiculos> findEntidade(Long entidade);

    @Query(value = "SELECT * FROM veiculos where id = :id", nativeQuery = true)
    List<Veiculos> findId(Long id);


}
