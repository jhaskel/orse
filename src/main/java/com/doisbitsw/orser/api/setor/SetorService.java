package com.doisbitsw.orser.api.setor;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SetorService {

    @Autowired

    private SetorRepository rep;
    public List<SetorDTO> getCarros() {
        List<SetorDTO> list = rep.findAll().stream().map(SetorDTO::create).collect(Collectors.toList());
        return list;
    }



    public SetorDTO getCarroById(Long id) {
        Optional<Setor> carro = rep.findById(id);
        return carro.map(SetorDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<SetorDTO> getEntidade(Long entidade) {
        return rep.findEntidade(entidade).stream().map(SetorDTO::create).collect(Collectors.toList());
    }


    public List<SetorDTO> getId(Long entidade,Long id) {
        return rep.findId(entidade,id).stream().map(SetorDTO::create).collect(Collectors.toList());
    }

    public SetorDTO insert(Setor setor) {
        Assert.isNull(setor.getId(),"Não foi possível inserir o registro");
        return SetorDTO.create(rep.save(setor));
    }

    public SetorDTO update(Setor setor, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Setor> optional = rep.findById(id);
        if(optional.isPresent()) {
            Setor db = optional.get();
            // Copiar as propriedades
            db.setNome(setor.getNome());
            db.setEntidade(setor.getEntidade());
            db.setResponsavel(setor.getResponsavel());
            db.setCargo(setor.getCargo());

            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return SetorDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
