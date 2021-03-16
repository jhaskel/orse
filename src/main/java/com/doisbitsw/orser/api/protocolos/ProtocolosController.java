package com.doisbitsw.orser.api.protocolos;

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

    @GetMapping("/ativo/{entidade}/{ano}")
    public ResponseEntity getAtivo(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano) {
        List<ProtocolosDTO> carros = service.getAtivo(entidade,ano);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/agendado/{entidade}")
    public ResponseEntity getAgendado(@PathVariable("entidade") Long entidade) {
        List<ProtocolosDTO> carros = service.getAgendado(entidade);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
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
