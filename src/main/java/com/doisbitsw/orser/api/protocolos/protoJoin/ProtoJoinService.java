package com.doisbitsw.orser.api.protocolos.protoJoin;

import com.doisbitsw.orser.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProtoJoinService {

    @Autowired

    private ProtoJoinRepository rep;
    public List<ProtoJoinDTO> getCarros() {
        List<ProtoJoinDTO> list = rep.findAll().stream().map(ProtoJoinDTO::create).collect(Collectors.toList());
        return list;
    }


    public ProtoJoinDTO getCarroById(Long id) {
        Optional<ProtoJoin> carro = rep.findById(id);
        return carro.map(ProtoJoinDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public ProtoJoinDTO insert(ProtoJoin protoJoin) {
        Assert.isNull(protoJoin.getId(),"Não foi possível inserir o registro");
        return ProtoJoinDTO.create(rep.save(protoJoin));
    }

    public List<ProtoJoinDTO> getAtivo(Long entidade, Long ano, Long setor) {
        return rep.findAtivo(entidade,ano,setor).stream().map(ProtoJoinDTO::create).collect(Collectors.toList());
    }
    public List<ProtoJoinDTO> getProto(Long entidade, Long ano) {
        return rep.findProto(entidade,ano).stream().map(ProtoJoinDTO::create).collect(Collectors.toList());
    }

    public List<ProtoJoinDTO> getProtoMaq(Long entidade, Long ano) {
        return rep.findProtoMaq(entidade,ano).stream().map(ProtoJoinDTO::create).collect(Collectors.toList());
    }



    public List<ProtoJoinDTO> getAgendado(Long entidade, Long ano, Long setor) {
        return rep.findAgendado(entidade,ano,setor).stream().map(ProtoJoinDTO::create).collect(Collectors.toList());
    }

    public List<ProtoJoinDTO> getAgendadoMes(Long entidade, Long ano, Long mes, Long setor) {
        return rep.findAgendadoMes(entidade,ano,mes,setor).stream().map(ProtoJoinDTO::create).collect(Collectors.toList());
    }

    public List<ProtoJoinDTO> getUser(Long entidade, Long usuario) {
        return rep.findUser(entidade,usuario).stream().map(ProtoJoinDTO::create).collect(Collectors.toList());
    }







    public long getCode(Long entidade){
        return rep.findCode(entidade);
    }


    public ProtoJoinDTO update(ProtoJoin protoJoin, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<ProtoJoin> optional = rep.findById(id);
        if(optional.isPresent()) {
            ProtoJoin db = optional.get();
            // Copiar as propriedades
            db.setEntidade(protoJoin.getEntidade());
            db.setContent(protoJoin.getContent());
            db.setAno(protoJoin.getAno());
            db.setCreated(protoJoin.getCreated());
            db.setDataAg(protoJoin.getDataAg());
            db.setDataFim(protoJoin.getDataFim());
            db.setPeriodoAg(protoJoin.getPeriodoAg());
            db.setDataIn(protoJoin.getDataIn());
            db.setPeriodoFim(protoJoin.getPeriodoFim());
            db.setPeriodoIn(protoJoin.getPeriodoIn());
            db.setIsagendado(protoJoin.getIsagendado());
            db.setIsativo(protoJoin.getIsativo());
            db.setIsuser(protoJoin.getIsuser());
            db.setIspago(protoJoin.getIspago());
            db.setObs(protoJoin.getObs());
            db.setMes(protoJoin.getMes());
            db.setLocalidade(protoJoin.getLocalidade());
            db.setNomeLocalidade(protoJoin.getNomeLocalidade());
            db.setUsuario(protoJoin.getUsuario());
            db.setNomeUsuario(protoJoin.getNomeUsuario());
            db.setServico(protoJoin.getServico());
            db.setNomeServico(protoJoin.getNomeServico());
            db.setIsfinalizado(protoJoin.getIsfinalizado());
            db.setSetor(protoJoin.getSetor());
            db.setStatus(protoJoin.getStatus());
            db.setModified(protoJoin.getModified());
            db.setCode(protoJoin.getCode());
            db.setCodi(protoJoin.getCodi());
            db.setMesAg(protoJoin.getMesAg());
            db.setIsmanual(protoJoin.getIsmanual());
            db.setFazer(protoJoin.getFazer());
            db.setRating(protoJoin.getRating());
            db.setAvaliacao(protoJoin.getAvaliacao());
            db.setDataAval(protoJoin.getDataAval());
            db.setCreatedBy(protoJoin.getCreatedBy());

            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ProtoJoinDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
