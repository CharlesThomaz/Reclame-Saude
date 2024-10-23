package br.com.devset.reclamesaude.repository;

import br.com.devset.reclamesaude.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT  c FROM Usuario c WHERE c.nome =:nome ")
    Optional<Usuario> buscarPorNome(@Param("nome") String nome);


    Optional<Usuario> findByEmail(String email);

}
