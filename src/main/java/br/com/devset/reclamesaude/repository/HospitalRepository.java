package br.com.devset.reclamesaude.repository;

import br.com.devset.reclamesaude.model.Hospital;
import br.com.devset.reclamesaude.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    @Query("SELECT  c FROM Hospital c WHERE c.nome =:nome ")
    Optional<Hospital> buscarPorNome(@Param("nome") String nome);
}
