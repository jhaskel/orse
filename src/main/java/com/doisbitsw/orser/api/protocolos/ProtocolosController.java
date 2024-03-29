package com.doisbitsw.orser.api.protocolos;

import com.doisbitsw.orser.api.protocolos.protoJoin.ProtoJoinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/protocolos")
public class ProtocolosController {
    @Autowired
    private ProtocolosService service;


    @GetMapping()
    public ResponseEntity get() {
        List<ProtocolosDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ProtocolosDTO carro = service.getCarroById(id);
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/ativo/{entidade}/{ano}/{setor}")
    public ResponseEntity getAtivo(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano,@PathVariable("setor") Long setor) {
        List<ProtocolosDTO> carros = service.getAtivo(entidade,ano,setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @GetMapping("/proto/{entidade}/{ano}")
    public ResponseEntity getProto(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano) {
        List<ProtocolosDTO> carros = service.getProto(entidade,ano);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }



    @GetMapping("/agendado/{entidade}/{ano}/{setor}")
    public ResponseEntity getAgendado(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano,@PathVariable("setor") Long setor) {
        List<ProtocolosDTO> carros = service.getAgendado(entidade,ano,setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @GetMapping("/agendadoAll/{entidade}/{ano}")
    public ResponseEntity getAgendadoAll(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano) {
        List<ProtocolosDTO> carros = service.getAgendadoAll(entidade,ano);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/agendadoMes/{entidade}/{ano}/{mes}/{setor}")
    public ResponseEntity getAgendado(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano,@PathVariable("mes") Long mes,@PathVariable("setor") Long setor) {
        List<ProtocolosDTO> carros = service.getAgendadoMes(entidade,ano,mes,setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/user/{entidade}/{usuario}")
    public ResponseEntity getUser(@PathVariable("entidade") Long entidade,@PathVariable("usuario") Long usuario) {
        List<ProtocolosDTO> carros = service.getUser(entidade,usuario);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/code/{entidade}")
    public long getCode(@PathVariable("entidade") Long entidade) {
        return service.getCode(entidade);
    }


    @PostMapping
    public ResponseEntity post(@RequestBody Protocolos protocolos) {
        ProtocolosDTO c = service.insert(protocolos);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Protocolos protocolos) {
        protocolos.setId(id);
        ProtocolosDTO c = service.update(protocolos, id);
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
