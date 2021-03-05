package com.doisbitsw.orser.api.imagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/imagens")
public class ImagensController {
    @Autowired
    private ImagensService service;


    @GetMapping()
    public ResponseEntity get() {
        List<ImagensDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }



    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ImagensDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }



    @PostMapping
    public ResponseEntity post(@RequestBody Imagens imagens) {

        ImagensDTO c = service.insert(imagens);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @GetMapping("/protocolo/{protocolo}")
    public ResponseEntity getProtocolo(@PathVariable("protocolo") Long protocolo) {
        List<ImagensDTO> carros = service.getProtocolo(protocolo);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Imagens imagens) {
        imagens.setId(id);
        ImagensDTO c = service.update(imagens, id);
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
