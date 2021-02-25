package com.doisbitsw.orser.api.valorServico;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ValorServicoService {

    @Autowired

    private ValorServicoRepository rep;
    public List<ValorServicoDTO> getCarros() {
        List<ValorServicoDTO> list = rep.findAll().stream().map(ValorServicoDTO::create).collect(Collectors.toList());
        return list;
    }



    public ValorServicoDTO getCarroById(Long id) {
        Optional<ValorServico> carro = rep.findById(id);
        return carro.map(ValorServicoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public ValorServicoDTO insert(ValorServico valorServico) {
        Assert.isNull(valorServico.getId(),"Não foi possível inserir o registro");
        return ValorServicoDTO.create(rep.save(valorServico));
    }

    public ValorServicoDTO update(ValorServico valorServico, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<ValorServico> optional = rep.findById(id);
        if(optional.isPresent()) {
            ValorServico db = optional.get();
            // Copiar as propriedades
            db.setServico(valorServico.getServico());
            db.setValor(valorServico.getValor());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ValorServicoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
