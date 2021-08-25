package com.doisbitsw.orser.api.veiculos;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculosService {

    @Autowired

    private VeiculosRepository rep;
    public List<VeiculosDTO> getCarros() {
        List<VeiculosDTO> list = rep.findAll().stream().map(VeiculosDTO::create).collect(Collectors.toList());
        return list;
    }



    public VeiculosDTO getCarroById(Long id) {
        Optional<Veiculos> carro = rep.findById(id);
        return carro.map(VeiculosDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public List<VeiculosDTO> getSetor(Long setor) {
        return rep.findSetor(setor).stream().map(VeiculosDTO::create).collect(Collectors.toList());
    }


    public List<VeiculosDTO> getEntidadeSetor(Long entidade,Long setor) {
        return rep.findEntidadeSetor(entidade,setor).stream().map(VeiculosDTO::create).collect(Collectors.toList());
    }


    public List<VeiculosDTO> getSetorAgendado(Long setor) {
        return rep.findSetorAgendado(setor).stream().map(VeiculosDTO::create).collect(Collectors.toList());
    }

    public List<VeiculosDTO> getEntidade(Long entidade) {
        return rep.findEntidade(entidade).stream().map(VeiculosDTO::create).collect(Collectors.toList());
    }


    public List<VeiculosDTO> getById(Long id) {
        return rep.findId(id).stream().map(VeiculosDTO::create).collect(Collectors.toList());
    }


    public VeiculosDTO insert(Veiculos maquinas) {
        Assert.isNull(maquinas.getId(),"Não foi possível inserir o registro");
        return VeiculosDTO.create(rep.save(maquinas));
    }

    public VeiculosDTO update(Veiculos maquinas, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Veiculos> optional = rep.findById(id);
        if(optional.isPresent()) {
            Veiculos db = optional.get();
            // Copiar as propriedades
            db.setNome(maquinas.getNome());
            db.setEntidade(maquinas.getEntidade());
            db.setIdentificador(maquinas.getIdentificador());
            db.setSetor(maquinas.getSetor());
            db.setIsativo(maquinas.getIsativo());
            db.setIsdisponivel(maquinas.getIsdisponivel());
            db.setIsveiculo(maquinas.getIsveiculo());
            db.setOperador(maquinas.getOperador());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return VeiculosDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
