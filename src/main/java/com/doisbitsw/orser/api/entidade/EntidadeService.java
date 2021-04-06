package com.doisbitsw.orser.api.entidade;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntidadeService {

    @Autowired

    private EntidadeRepository rep;
    public List<EntidadeDTO> getCarros() {
        List<EntidadeDTO> list = rep.findAll().stream().map(EntidadeDTO::create).collect(Collectors.toList());
        return list;
    }



    public EntidadeDTO getCarroById(Long id) {
        Optional<Entidade> carro = rep.findById(id);
        return carro.map(EntidadeDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<EntidadeDTO> getEntidade(Long id) {
        return rep.findEntidade(id).stream().map(EntidadeDTO::create).collect(Collectors.toList());
    }


    public EntidadeDTO insert(Entidade entidade) {
        Assert.isNull(entidade.getId(),"Não foi possível inserir o registro");
        return EntidadeDTO.create(rep.save(entidade));
    }

    public EntidadeDTO update(Entidade entidade, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Entidade> optional = rep.findById(id);
        if(optional.isPresent()) {
            Entidade db = optional.get();
            // Copiar as propriedades
            db.setNome(entidade.getNome());
            db.setCidade(entidade.getCidade());
            db.setImagem(entidade.getImagem());
            db.setPrefeito(entidade.getPrefeito());
            db.setSigla(entidade.getSigla());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return EntidadeDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
