package br.edu.ifsp.bra.medsea.controller;

import br.edu.ifsp.bra.medsea.model.Visitante;
import br.edu.ifsp.bra.medsea.repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitante")
public class VisitanteController {

    @Autowired
    private VisitanteRepository visitanteRepo;

    @PostMapping
    public ResponseEntity<Visitante> createVisitante(@RequestBody Visitante newVisitante) {
        Visitante createdVisitante = visitanteRepo.save(newVisitante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVisitante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitante> getVisitanteById(@PathVariable int id) {
        return visitanteRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public List<Visitante> getAllVisitantes() {
        return visitanteRepo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visitante> updateVisitante(@PathVariable int id, @RequestBody Visitante updatedVisitante) {
        return visitanteRepo.findById(id)
                .map(visitante -> {
                    visitante.setNome(updatedVisitante.getNome());
                    visitante.setDocumentoIdentidade(updatedVisitante.getDocumentoIdentidade());
                    visitanteRepo.save(visitante);
                    return ResponseEntity.ok(visitante);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitante(@PathVariable int id) {
        return visitanteRepo.findById(id)
                .map(visitante -> {
                    visitanteRepo.delete(visitante);
                    return ResponseEntity.noContent().<Void>build(); // Especifica explicitamente o tipo Void
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }    
}
