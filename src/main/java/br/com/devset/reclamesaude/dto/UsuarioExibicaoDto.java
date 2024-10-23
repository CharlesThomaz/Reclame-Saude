package br.com.devset.reclamesaude.dto;

import br.com.devset.reclamesaude.model.Usuario;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
        String email
) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());

    }
}

