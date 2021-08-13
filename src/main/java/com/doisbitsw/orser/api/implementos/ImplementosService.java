package com.doisbitsw.orser.api.implementos;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImplementosService {

    @Autowired

    private ImplementosRepository rep;
    public List<ImplementosDTO> getCarros() {
        List<ImplementosDTO> list = rep.findAll().stream().map(ImplementosDTO::create).collect(Collectors.toList());
        return list;
    }



    public ImplementosDTO getCarroById(Long id) {
        Optional<Implementos> carro = rep.findById(id);
        return carro.map(ImplementosDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public List<ImplementosDTO> getSetor(Long setor) {
        return rep.findSetor(setor).stream().map(ImplementosDTO::create).collect(Collectors.toList());
    }


    public List<ImplementosDTO> getEntidadeSetor(Long entidade, Long setor) {
        return rep.findEntidadeSetor(entidade,setor).stream().map(ImplementosDTO::create).collect(Collectors.toList());
    }

    public List<ImplementosDTO> getEntidade(Long entidade) {
        return rep.findEntidade(entidade).stream().map(ImplementosDTO::create).collect(Collectors.toList());
    }


    public List<ImplementosDTO> getById(Long id) {
        return rep.findId(id).stream().map(ImplementosDTO::create).collect(Collectors.toList());
    }


    public ImplementosDTO insert(Implementos maquinas) {
        Assert.isNull(maquinas.getId(),"Não foi possível inserir o registro");
        return ImplementosDTO.create(rep.save(maquinas));
    }

    public ImplementosDTO update(Implementos maquinas, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Implementos> optional = rep.findById(id);
        if(optional.isPresent()) {
            Implementos db = optional.get();
            // Copiar as propriedades
            db.setNome(maquinas.getNome());
            db.setEntidade(maquinas.getEntidade());
            db.setIdentificador(maquinas.getIdentificador());
            db.setSetor(maquinas.getSetor());
            db.setIsativo(maquinas.getIsativo());
            db.setIsdisponivel(maquinas.getIsdisponivel());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ImplementosDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
