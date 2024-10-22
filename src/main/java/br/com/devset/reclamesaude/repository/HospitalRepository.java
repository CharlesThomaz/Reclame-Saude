package br.com.devset.reclamesaude.repository;

import br.com.devset.reclamesaude.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    // Exemplo: List<Hospital> findByNome(String nome);
}
