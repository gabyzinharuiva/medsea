package br.edu.ifsp.bra.medsea.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifsp.bra.medsea.model.Depoimento;

@RestController
@RequestMapping("/depoimento")
public class DepoimentoController {
    private List<Depoimento> historicoDepoimentos = new ArrayList<>();

    public DepoimentoController() {
        historicoDepoimentos.add(new Depoimento(1, "Meu Cotidiano", "AAAA", 1));
    }

    // Método GET para obter todos os depoimentos
    @GetMapping
    public List<Depoimento> getAllDepoimentos() {
        return historicoDepoimentos;
    }

    // Método GET para obter um depoimento específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Depoimento> getDepoimentoById(@PathVariable int id) {
        Optional<Depoimento> depoimento = historicoDepoimentos.stream()
            .filter(d -> d.getId() == id)
            .findFirst();

        return depoimento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método POST para criar um novo depoimento
    @PostMapping ("/newdepoimento")
    public Depoimento createNewDepoimento(@RequestBody Depoimento newDepoimento) {
        newDepoimento.setId(historicoDepoimentos.size() + 1);
        historicoDepoimentos.add(newDepoimento);
        return newDepoimento;
    }

    // Método PUT para atualizar um depoimento existente
    @PutMapping("/{id}")
    public ResponseEntity<Depoimento> updateDepoimento(@PathVariable int id, @RequestBody Depoimento depoimentoAtualizado) {
        Optional<Depoimento> depoimentoExistente = historicoDepoimentos.stream()
            .filter(d -> d.getId() == id)
            .findFirst();

        if (depoimentoExistente.isPresent()) {
            Depoimento depoimento = depoimentoExistente.get();
            depoimento.setTituloDepoimento(depoimentoAtualizado.getTituloDepoimento());
            depoimento.setConteudoDepoimento(depoimentoAtualizado.getConteudoDepoimento());
            depoimento.setUsuarioId(depoimentoAtualizado.getUsuarioId());
            return ResponseEntity.ok(depoimento);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Método DELETE para remover um depoimento
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepoimento(@PathVariable int id) {
        Optional<Depoimento> depoimentoToRemove = historicoDepoimentos.stream()
            .filter(d -> d.getId() == id)
            .findFirst();

        if (depoimentoToRemove.isPresent()) {
            historicoDepoimentos.remove(depoimentoToRemove.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Depoimento deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Depoimento não encontrado.");
        }
    }
}
