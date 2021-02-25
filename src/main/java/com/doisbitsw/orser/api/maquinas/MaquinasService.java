package com.doisbitsw.orser.api.maquinas;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaquinasService {

    @Autowired

    private MaquinasRepository rep;
    public List<MaquinasDTO> getCarros() {
        List<MaquinasDTO> list = rep.findAll().stream().map(MaquinasDTO::create).collect(Collectors.toList());
        return list;
    }



    public MaquinasDTO getCarroById(Long id) {
        Optional<Maquinas> carro = rep.findById(id);
        return carro.map(MaquinasDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public MaquinasDTO insert(Maquinas maquinas) {
        Assert.isNull(maquinas.getId(),"Não foi possível inserir o registro");
        return MaquinasDTO.create(rep.save(maquinas));
    }

    public MaquinasDTO update(Maquinas maquinas, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Maquinas> optional = rep.findById(id);
        if(optional.isPresent()) {
            Maquinas db = optional.get();
            // Copiar as propriedades
            db.setNome(maquinas.getNome());
            db.setEntidade(maquinas.getEntidade());
            db.setPlaca(maquinas.getPlaca());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return MaquinasDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
