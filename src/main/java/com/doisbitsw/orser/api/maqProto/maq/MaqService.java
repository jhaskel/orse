package com.doisbitsw.orser.api.maqProto.maq;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaqService {

    @Autowired

    private MaqRepository rep;
    public List<MaqDTO> getCarros() {
        List<MaqDTO> list = rep.findAll().stream().map(MaqDTO::create).collect(Collectors.toList());
        return list;
    }



    public MaqDTO getCarroById(Long id) {
        Optional<Maq> carro = rep.findById(id);
        return carro.map(MaqDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }



    public MaqDTO insert(Maq maq) {
        Assert.isNull(maq.getId(),"Não foi possível inserir o registro");
        return MaqDTO.create(rep.save(maq));
    }

    public MaqDTO update(Maq maq, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Maq> optional = rep.findById(id);
        if(optional.isPresent()) {
            Maq db = optional.get();
            // Copiar as propriedades
            db.setProtocolo(maq.getProtocolo());
            db.setMaquina(maq.getMaquina());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return MaqDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
