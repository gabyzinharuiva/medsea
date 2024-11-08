package br.edu.ifsp.bra.medsea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifsp.bra.medsea.model.Familiar;

public interface FamiliarRepository extends JpaRepository<Familiar, Integer> {
    // Métodos de consulta personalizados podem ser adicionados aqui, se necessário
}
