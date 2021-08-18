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

    @GetMapping("/proto/{entidade}/{ano}")
    public ResponseEntity getProtoMaq(@PathVariable("entidade") Long entidade,@PathVariable("ano") Long ano) {
        List<ProtoJoinDTO> carros = service.getProtoMaq(entidade,ano);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
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
