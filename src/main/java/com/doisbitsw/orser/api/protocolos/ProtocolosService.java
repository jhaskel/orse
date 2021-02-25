package com.doisbitsw.orser.api.protocolos;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProtocolosService {

    @Autowired

    private ProtocolosRepository rep;
    public List<ProtocolosDTO> getCarros() {
        List<ProtocolosDTO> list = rep.findAll().stream().map(ProtocolosDTO::create).collect(Collectors.toList());
        return list;
    }



    public ProtocolosDTO getCarroById(Long id) {
        Optional<Protocolos> carro = rep.findById(id);
        return carro.map(ProtocolosDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public ProtocolosDTO insert(Protocolos protocolos) {
        Assert.isNull(protocolos.getId(),"Não foi possível inserir o registro");
        return ProtocolosDTO.create(rep.save(protocolos));
    }

    public ProtocolosDTO update(Protocolos protocolos, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Protocolos> optional = rep.findById(id);
        if(optional.isPresent()) {
            Protocolos db = optional.get();
            // Copiar as propriedades
            db.setEntidade(protocolos.getEntidade());
            db.setContent(protocolos.getContent());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ProtocolosDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
