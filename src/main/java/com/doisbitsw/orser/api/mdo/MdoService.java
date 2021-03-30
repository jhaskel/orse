package com.doisbitsw.orser.api.mdo;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MdoService {

    @Autowired

    private MdoRepository rep;
    public List<MdoDTO> getCarros() {
        List<MdoDTO> list = rep.findAll().stream().map(MdoDTO::create).collect(Collectors.toList());
        return list;
    }

    public MdoDTO getCarroById(Long id) {
        Optional<Mdo> carro = rep.findById(id);
        return carro.map(MdoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public List<MdoDTO> getSetor(Long setor) {
        return rep.findSetor(setor).stream().map(MdoDTO::create).collect(Collectors.toList());
    }


    public List<MdoDTO> getById(Long id) {
        return rep.findId(id).stream().map(MdoDTO::create).collect(Collectors.toList());
    }


    public MdoDTO insert(Mdo maquinas) {
        Assert.isNull(maquinas.getId(),"Não foi possível inserir o registro");
        return MdoDTO.create(rep.save(maquinas));
    }

    public MdoDTO update(Mdo maquinas, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Mdo> optional = rep.findById(id);
        if(optional.isPresent()) {
            Mdo db = optional.get();
            // Copiar as propriedades
            db.setNome(maquinas.getNome());
            db.setEntidade(maquinas.getEntidade());
            db.setSetor(maquinas.getSetor());
            db.setIsdisponivel(maquinas.getIsdisponivel());
            db.setCargo(maquinas.getCargo());
            db.setIsativo(maquinas.getIsativo());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return MdoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
