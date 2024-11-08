package br.edu.ifsp.bra.medsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifsp.bra.medsea.model.Familiar;
import br.edu.ifsp.bra.medsea.repository.FamiliarRepository;

@RestController
@RequestMapping("/familiar")
public class FamiliarController {

    @Autowired
    private FamiliarRepository familiarRepo;

    @PostMapping
    public ResponseEntity<Familiar> createFamiliar(@RequestBody Familiar newFamiliar) {
        Familiar createdFamiliar = familiarRepo.save(newFamiliar);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFamiliar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Familiar> getFamiliarById(@PathVariable int id) {
        return familiarRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public List<Familiar> getAllFamiliares() {
        return familiarRepo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Familiar> updateFamiliar(@PathVariable int id, @RequestBody Familiar updatedFamiliar) {
        return familiarRepo.findById(id)
                .map(familiar -> {
                    familiar.setCartaoSUSFamiliar(updatedFamiliar.getCartaoSUSFamiliar());
                    familiar.setConvenioFamiliar(updatedFamiliar.getConvenioFamiliar());
                    familiar.setPaciente(updatedFamiliar.getPaciente());
                    familiarRepo.save(familiar);
                    return ResponseEntity.ok(familiar);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFamiliar(@PathVariable int id) {
        return familiarRepo.findById(id)
                .map(familiar -> {
                    familiarRepo.delete(familiar);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}