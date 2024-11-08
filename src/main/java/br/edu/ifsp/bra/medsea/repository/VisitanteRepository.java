package br.edu.ifsp.bra.medsea.repository;

import br.edu.ifsp.bra.medsea.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Integer> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}
