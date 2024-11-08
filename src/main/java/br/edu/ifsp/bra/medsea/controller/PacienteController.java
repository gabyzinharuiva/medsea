package br.edu.ifsp.bra.medsea.controller;

import br.edu.ifsp.bra.medsea.model.Paciente;
import br.edu.ifsp.bra.medsea.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepo;

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente newPaciente) {
        Paciente createdPaciente = pacienteRepo.save(newPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPaciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Integer id) {
        return pacienteRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Integer id, @RequestBody Paciente updatedPaciente) {
        return pacienteRepo.findById(id)
                .map(paciente -> {
                    paciente.setCartaoSUSPaciente(updatedPaciente.getCartaoSUSPaciente());
                    paciente.setConvenioPaciente(updatedPaciente.getConvenioPaciente());
                    pacienteRepo.save(paciente);
                    return ResponseEntity.ok(paciente);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Integer id) {
        return pacienteRepo.findById(id)
                .map(paciente -> {
                    pacienteRepo.delete(paciente);
                    return ResponseEntity.noContent().<Void>build(); // Especifica explicitamente o tipo Void
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
}