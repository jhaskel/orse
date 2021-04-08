package com.doisbitsw.orser.api.maqProto;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaqProtoService {

    @Autowired

    private MaqProtoRepository rep;
    public List<MaqProtoDTO> getCarros() {
        List<MaqProtoDTO> list = rep.findAll().stream().map(MaqProtoDTO::create).collect(Collectors.toList());
        return list;
    }



    public MaqProtoDTO getCarroById(Long id) {
        Optional<MaqProto> carro = rep.findById(id);
        return carro.map(MaqProtoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<MaqProtoDTO> getProtocolo(Long protocolo) {
        return rep.findProtocolo(protocolo).stream().map(MaqProtoDTO::create).collect(Collectors.toList());
    }

    public List<MaqProtoDTO> getBuscaProtocolo(Long protocolo) {
        return rep.findBuscaProtocolo(protocolo).stream().map(MaqProtoDTO::create).collect(Collectors.toList());
    }

   /* public List<MaqProtoDTO> getRelatorio(Long setor) {
        return rep.findRelatorio(setor).stream().map(MaqProtoDTO::create).collect(Collectors.toList());
    }*/

    public MaqProtoDTO insert(MaqProto maqProto) {
        Assert.isNull(maqProto.getId(),"Não foi possível inserir o registro");
        return MaqProtoDTO.create(rep.save(maqProto));
    }

    public MaqProtoDTO update(MaqProto maqProto, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<MaqProto> optional = rep.findById(id);
        if(optional.isPresent()) {
            MaqProto db = optional.get();
            // Copiar as propriedades
            db.setProtocolo(maqProto.getProtocolo());
            db.setMaquina(maqProto.getMaquina());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return MaqProtoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
