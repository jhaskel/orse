package com.doisbitsw.orser.api.setor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/setor")
public class SetorController {
    @Autowired
    private SetorService service;


    @GetMapping()
    public ResponseEntity get() {
        List<SetorDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }



    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        SetorDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }

    @GetMapping("/entidade/{entidade}")
    public ResponseEntity getEntidade(@PathVariable("entidade") Long entidade) {
        List<SetorDTO> carros = service.getEntidade(entidade);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }



    @GetMapping("/id/{entidade}/{id}")
    public ResponseEntity getId(@PathVariable("entidade") Long entidade,@PathVariable("id") Long id) {
        List<SetorDTO> carros = service.getId(entidade,id);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }



    @PostMapping
    public ResponseEntity post(@RequestBody Setor setor) {

        SetorDTO c = service.insert(setor);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Setor setor) {
        setor.setId(id);
        SetorDTO c = service.update(setor, id);
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
