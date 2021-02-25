package com.doisbitsw.orser.api.valorServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/valor")
public class ValorServicoController {
    @Autowired
    private ValorServicoService service;


    @GetMapping()
    public ResponseEntity get() {
        List<ValorServicoDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }



    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ValorServicoDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }



    @PostMapping
    public ResponseEntity post(@RequestBody ValorServico valorServico) {

        ValorServicoDTO c = service.insert(valorServico);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody ValorServico valorServico) {
        valorServico.setId(id);
        ValorServicoDTO c = service.update(valorServico, id);
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
