package br.com.devset.reclamesaude.repository;

import br.com.devset.reclamesaude.model.Reclamacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Long> {
}
