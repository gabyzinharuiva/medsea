package br.edu.ifsp.bra.medsea.controller;

import br.edu.ifsp.bra.medsea.model.Perfil;
import br.edu.ifsp.bra.medsea.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    // Método GET para todos os perfis
    @GetMapping
    public List<Perfil> getAllPerfis() {
        return perfilRepository.findAll();
    }

    // Método GET para um perfil específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfilById(@PathVariable int id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método POST para adicionar um novo perfil
    @PostMapping
    public ResponseEntity<Perfil> addPerfil(@RequestBody Perfil perfil) {
        Perfil createdPerfil = perfilRepository.save(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerfil);
    }

    // Método PUT para atualizar um perfil existente
    @PutMapping("/{id}")
    public ResponseEntity<Perfil> updatePerfil(@PathVariable int id, @RequestBody Perfil perfilAtualizado) {
        return perfilRepository.findById(id)
                .map(perfil -> {
                    perfil.setNomeUsuario(perfilAtualizado.getNomeUsuario());
                    perfil.setBioUsuario(perfilAtualizado.getBioUsuario());
                    Perfil perfilSalvo = perfilRepository.save(perfil);
                    return ResponseEntity.ok(perfilSalvo);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método DELETE para excluir um perfil pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfil(@PathVariable int id) {
        return perfilRepository.findById(id)
                .map(perfil -> {
                    perfilRepository.delete(perfil);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
