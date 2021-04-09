package com.doisbitsw.orser.api.protocolos;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProtocolosService {

    @Autowired

    private ProtocolosRepository rep;
    public List<ProtocolosDTO> getCarros() {
        List<ProtocolosDTO> list = rep.findAll().stream().map(ProtocolosDTO::create).collect(Collectors.toList());
        return list;
    }


    public ProtocolosDTO getCarroById(Long id) {
        Optional<Protocolos> carro = rep.findById(id);
        return carro.map(ProtocolosDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public ProtocolosDTO insert(Protocolos protocolos) {
        Assert.isNull(protocolos.getId(),"Não foi possível inserir o registro");
        return ProtocolosDTO.create(rep.save(protocolos));
    }

    public List<ProtocolosDTO> getAtivo(Long entidade, Long ano,Long setor) {
        return rep.findAtivo(entidade,ano,setor).stream().map(ProtocolosDTO::create).collect(Collectors.toList());
    }


    public List<ProtocolosDTO> getAgendado(Long entidade, Long ano,Long setor) {
        return rep.findAgendado(entidade,ano,setor).stream().map(ProtocolosDTO::create).collect(Collectors.toList());
    }

    public List<ProtocolosDTO> getAgendadoMes(Long entidade, Long ano,Long mes,Long setor) {
        return rep.findAgendadoMes(entidade,ano,mes,setor).stream().map(ProtocolosDTO::create).collect(Collectors.toList());
    }

    public List<ProtocolosDTO> getUser(Long entidade,Long usuario) {
        return rep.findUser(entidade,usuario).stream().map(ProtocolosDTO::create).collect(Collectors.toList());
    }







    public long getCode(Long entidade){
        return rep.findCode(entidade);
    }


    public ProtocolosDTO update(Protocolos protocolos, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Protocolos> optional = rep.findById(id);
        if(optional.isPresent()) {
            Protocolos db = optional.get();
            // Copiar as propriedades
            db.setEntidade(protocolos.getEntidade());
            db.setContent(protocolos.getContent());
            db.setAno(protocolos.getAno());
            db.setCreated(protocolos.getCreated());
            db.setDataAg(protocolos.getDataAg());
            db.setDataFim(protocolos.getDataFim());
            db.setPeriodoAg(protocolos.getPeriodoAg());
            db.setDataIn(protocolos.getDataIn());
            db.setPeriodoFim(protocolos.getPeriodoFim());
            db.setPeriodoIn(protocolos.getPeriodoIn());
            db.setIsagendado(protocolos.getIsagendado());
            db.setIsativo(protocolos.getIsativo());
            db.setIsuser(protocolos.getIsuser());
            db.setIspago(protocolos.getIspago());
            db.setObs(protocolos.getObs());
            db.setMes(protocolos.getMes());
            db.setLocalidade(protocolos.getLocalidade());
            db.setNomeLocalidade(protocolos.getNomeLocalidade());
            db.setUsuario(protocolos.getUsuario());
            db.setNomeUsuario(protocolos.getNomeUsuario());
            db.setServico(protocolos.getServico());
            db.setNomeServico(protocolos.getNomeServico());
            db.setIsfinalizado(protocolos.getIsfinalizado());
            db.setSetor(protocolos.getSetor());
            db.setStatus(protocolos.getStatus());
            db.setModified(protocolos.getModified());
            db.setCode(protocolos.getCode());
            db.setCodi(protocolos.getCodi());
            db.setMesAg(protocolos.getMesAg());
            db.setIsmanual(protocolos.getIsmanual());
            db.setFazer(protocolos.getFazer());

            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ProtocolosDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
