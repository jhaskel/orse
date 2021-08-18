package com.doisbitsw.orser.api.protocolos.protoJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/protoJoin")
public class ProtoJoinController {
    @Autowired
    private ProtoJoinService service;


    @GetMapping()
    public ResponseEntity get() {
        List<ProtoJoinDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ProtoJoinDTO carro = service.getCarroById(id);
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/ativo/{entidade}/{ano}/{setor}")
    public ResponseEntity getAtivo(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano,@PathVariable("setor") Long setor) {
        List<ProtoJoinDTO> carros = service.getAtivo(entidade,ano,setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @GetMapping("/proto/{entidade}/{ano}")
    public ResponseEntity getProto(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano) {
        List<ProtoJoinDTO> carros = service.getProto(entidade,ano);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/protoj/{entidade}/{ano}")
    public ResponseEntity getProtoMaq(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano) {
        List<ProtoJoinDTO> carros = service.getProtoMaq(entidade,ano);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/agendado/{entidade}/{ano}/{setor}")
    public ResponseEntity getAgendado(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano,@PathVariable("setor") Long setor) {
        List<ProtoJoinDTO> carros = service.getAgendado(entidade,ano,setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/agendadoMes/{entidade}/{ano}/{mes}/{setor}")
    public ResponseEntity getAgendado(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano,@PathVariable("mes") Long mes,@PathVariable("setor") Long setor) {
        List<ProtoJoinDTO> carros = service.getAgendadoMes(entidade,ano,mes,setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/user/{entidade}/{usuario}")
    public ResponseEntity getUser(@PathVariable("entidade") Long entidade,@PathVariable("usuario") Long usuario) {
        List<ProtoJoinDTO> carros = service.getUser(entidade,usuario);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/code/{entidade}")
    public long getCode(@PathVariable("entidade") Long entidade) {
        return service.getCode(entidade);
    }


    @PostMapping
    public ResponseEntity post(@RequestBody ProtoJoin protoJoin) {
        ProtoJoinDTO c = service.insert(protoJoin);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody ProtoJoin protoJoin) {
        protoJoin.setId(id);
        ProtoJoinDTO c = service.update(protoJoin, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
