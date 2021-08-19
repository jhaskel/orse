package com.doisbitsw.orser.api.protocolos.protoJoin;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProtoJoinRepository extends JpaRepository<ProtoJoin, Long> {


    @Query(value = "select pro.* , maq.maquina as maquina,vei.nome as nomevei\n" +
            "from protocolos pro\n" +
            "left join maq_proto maq on maq.protocolo = pro.id\n" +
            "left join veiculos vei on vei.id = maq.maquina\n" +
            "where maq.maquina = :entidade and ano = :ano and pro.ismanual = false pro.status='Agendado'\n" +
            "group by pro.id" , nativeQuery = true)
    List<ProtoJoin> findProtoMaq(Long entidade, Long ano);



}
