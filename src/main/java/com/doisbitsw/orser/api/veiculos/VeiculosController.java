package com.doisbitsw.orser.api.veiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/veiculos")
public class VeiculosController {
    @Autowired
    private VeiculosService service;


    @GetMapping()
    public ResponseEntity get() {
        List<VeiculosDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }



    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        VeiculosDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }

    @GetMapping("/ativo/{setor}")
    public ResponseEntity getSetor(@PathVariable("setor") Long setor) {
        List<VeiculosDTO> carros = service.getSetor(setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/entidadeSetor/{entidade}/{setor}")
    public ResponseEntity getEntidadeSetor(@PathVariable("entidade") Long entidade,@PathVariable("setor") Long setor) {
        List<VeiculosDTO> carros = service.getEntidadeSetor(entidade,setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @GetMapping("/entidade/{entidade}")
    public ResponseEntity getEntidade(@PathVariable("entidade") Long entidade) {
        List<VeiculosDTO> carros = service.getEntidade(entidade);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @GetMapping("/setorAgendado/{setor}/{cod}")
    public ResponseEntity getSetorAgendado(@PathVariable("setor") Long setor,@PathVariable("cod") String cod) {
        List<VeiculosDTO> carros = service.getSetorAgendado(setor,cod);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        List<VeiculosDTO> carros = service.getById(id);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }


    @PostMapping
    public ResponseEntity post(@RequestBody Veiculos maquinas) {

        VeiculosDTO c = service.insert(maquinas);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Veiculos maquinas) {
        maquinas.setId(id);
        VeiculosDTO c = service.update(maquinas, id);
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
