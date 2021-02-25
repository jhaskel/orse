package com.doisbitsw.orser.api.maqProto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/maqproto")
public class MaqProtoController {
    @Autowired
    private MaqProtoService service;


    @GetMapping()
    public ResponseEntity get() {
        List<MaqProtoDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }



    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        MaqProtoDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }



    @PostMapping
    public ResponseEntity post(@RequestBody MaqProto maqProto) {

        MaqProtoDTO c = service.insert(maqProto);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody MaqProto maqProto) {
        maqProto.setId(id);
        MaqProtoDTO c = service.update(maqProto, id);
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