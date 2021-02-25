package com.doisbitsw.orser.api.localidades;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocalidadesService {

    @Autowired

    private LocalidadesRepository rep;
    public List<LocalidadesDTO> getCarros() {
        List<LocalidadesDTO> list = rep.findAll().stream().map(LocalidadesDTO::create).collect(Collectors.toList());
        return list;
    }



    public LocalidadesDTO getCarroById(Long id) {
        Optional<Localidades> carro = rep.findById(id);
        return carro.map(LocalidadesDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public LocalidadesDTO insert(Localidades localidades) {
        Assert.isNull(localidades.getId(),"Não foi possível inserir o registro");
        return LocalidadesDTO.create(rep.save(localidades));
    }

    public LocalidadesDTO update(Localidades localidades, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Localidades> optional = rep.findById(id);
        if(optional.isPresent()) {
            Localidades db = optional.get();
            // Copiar as propriedades
            db.setNome(localidades.getNome());
            db.setEntidade(localidades.getEntidade());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return LocalidadesDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
