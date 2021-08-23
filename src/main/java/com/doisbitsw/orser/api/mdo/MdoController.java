package com.doisbitsw.orser.api.mdo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mdo")
public class MdoController {
    @Autowired
    private MdoService service;


    @GetMapping()
    public ResponseEntity get() {
        List<MdoDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }



    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        MdoDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }

    @GetMapping("/ativo/{setor}")
    public ResponseEntity getSetor(@PathVariable("setor") Long setor) {
        List<MdoDTO> carros = service.getSetor(setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        List<MdoDTO> carros = service.getById(id);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @GetMapping("/entidadeSetor/{entidade}/{setor}")
    public ResponseEntity getEntidadeSetor(@PathVariable("entidade") Long entidade,@PathVariable("setor") Long setor) {
        List<MdoDTO> carros = service.getEntidadeSetor(entidade,setor);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/entidade/{entidade}")
    public ResponseEntity getEntidade(@PathVariable("entidade") Long entidade) {
        List<MdoDTO> carros = service.getEntidade(entidade);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }




    @PostMapping
    public ResponseEntity post(@RequestBody Mdo maquinas) {

        MdoDTO c = service.insert(maquinas);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Mdo maquinas) {
        maquinas.setId(id);
        MdoDTO c = service.update(maquinas, id);
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
