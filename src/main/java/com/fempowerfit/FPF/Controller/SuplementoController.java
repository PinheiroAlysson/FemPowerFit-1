package com.fempowerfit.FPF.Controller;

import com.fempowerfit.FPF.Model.Suplemento;
import com.fempowerfit.FPF.repository.SuplementoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suplemento")
public class SuplementoController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SuplementoRepository suplementoRepository;

    @GetMapping("/meusSuplementos")
    public List<Suplemento> listar() {
        List<Suplemento> suplementos = new ArrayList<>();
        for (Suplemento entity : suplementoRepository.findAll()) {
            suplementos.add(toModel(entity));
        }
        return suplementos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suplemento> get(@PathVariable Long id) {
        Optional<Suplemento> suplementoOptional = suplementoRepository.findById(id);

        if (suplementoOptional.isEmpty())
            return ResponseEntity.notFound().build();

        Suplemento suplemento = toModel(suplementoOptional.get());
        return ResponseEntity.ok().body(suplemento);
    }
    
    @PostMapping
    public ResponseEntity<Suplemento> cadastrarSuplemento(@RequestBody Suplemento suplemento) {
        Suplemento entity = toEntity(suplemento);
        suplementoRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(suplemento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suplemento> atualizarSuplemento(@PathVariable Long id, @RequestBody Suplemento suplemento) {
        Optional<Suplemento> suplementoOptional = suplementoRepository.findById(id);

        if (suplementoOptional.isEmpty())
            return ResponseEntity.notFound().build();

        Suplemento suplementoEncontrado = suplementoOptional.get();
        suplementoEncontrado.setMarca(suplemento.getMarca());
        suplementoEncontrado.setQuantidade(suplemento.getQuantidade());
        suplementoEncontrado.setTipo(suplemento.getTipo());

        suplementoRepository.save(suplementoEncontrado);
        return ResponseEntity.ok().body(toModel(suplementoEncontrado));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSuplemento(@PathVariable Long id) {
        Optional<Suplemento> suplementoOptional = suplementoRepository.findById(id);

        if (suplementoOptional.isEmpty())
            return ResponseEntity.notFound().build();

        suplementoRepository.delete(suplementoOptional.get());
        return ResponseEntity.noContent().build();
    }

    private Suplemento toModel(Suplemento suplementoEntity) {
        return new Suplemento(suplementoEntity.getId(), suplementoEntity.getMarca(), suplementoEntity.getTipo(), suplementoEntity.getQuantidade());
    }

    private Suplemento toEntity(Suplemento suplemento) {
        Suplemento entity = new Suplemento();
        entity.setId(suplemento.getId());
        entity.setMarca(suplemento.getMarca());
        entity.setTipo(suplemento.getTipo());
        entity.setQuantidade(suplemento.getQuantidade());
        return entity;
    }
}
