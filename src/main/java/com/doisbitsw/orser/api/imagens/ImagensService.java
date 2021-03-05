package com.doisbitsw.orser.api.imagens;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImagensService {

    @Autowired

    private ImagensRepository rep;
    public List<ImagensDTO> getCarros() {
        List<ImagensDTO> list = rep.findAll().stream().map(ImagensDTO::create).collect(Collectors.toList());
        return list;
    }



    public ImagensDTO getCarroById(Long id) {
        Optional<Imagens> carro = rep.findById(id);
        return carro.map(ImagensDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<ImagensDTO> getProtocolo(Long protocolo) {
        return rep.findProtocolo(protocolo).stream().map(ImagensDTO::create).collect(Collectors.toList());
    }


    public ImagensDTO insert(Imagens imagens) {
        Assert.isNull(imagens.getId(),"Não foi possível inserir o registro");
        return ImagensDTO.create(rep.save(imagens));
    }

    public ImagensDTO update(Imagens imagens, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Imagens> optional = rep.findById(id);
        if(optional.isPresent()) {
            Imagens db = optional.get();
            // Copiar as propriedades
            db.setProtocolo(imagens.getProtocolo());
            db.setImagem(imagens.getImagem());
            db.setIsprotocolo(imagens.getIsprotocolo());
            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ImagensDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
