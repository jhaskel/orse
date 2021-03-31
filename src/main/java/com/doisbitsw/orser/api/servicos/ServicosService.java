package com.doisbitsw.orser.api.servicos;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicosService {

    @Autowired

    private ServicosRepository rep;
    public List<ServicosDTO> getCarros() {
        List<ServicosDTO> list = rep.findAll().stream().map(ServicosDTO::create).collect(Collectors.toList());
        return list;
    }



    public ServicosDTO getCarroById(Long id) {
        Optional<Servicos> carro = rep.findById(id);
        return carro.map(ServicosDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<ServicosDTO> getEntidadeSetor(Long entidade,Long setor) {
        return rep.findEntidadeSetor(entidade,setor).stream().map(ServicosDTO::create).collect(Collectors.toList());
    }

    public List<ServicosDTO> getPublico(Long entidade) {
        return rep.findPublico(entidade).stream().map(ServicosDTO::create).collect(Collectors.toList());
    }


    public ServicosDTO insert(Servicos servicos) {
        Assert.isNull(servicos.getId(),"Não foi possível inserir o registro");
        return ServicosDTO.create(rep.save(servicos));
    }



    public ServicosDTO update(Servicos servicos, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Servicos> optional = rep.findById(id);
        if(optional.isPresent()) {
            Servicos db = optional.get();
            // Copiar as propriedades
            db.setNome(servicos.getNome());
            db.setEntidade(servicos.getEntidade());
            db.setUnidade(servicos.getUnidade());
            db.setIsmanual(servicos.getIsmanual());
            db.setIspago(servicos.getIspago());
            db.setValor(servicos.getValor());
            db.setSetor(servicos.getSetor());
            db.setIspublico(servicos.getIspublico());

            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ServicosDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
