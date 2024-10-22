package br.com.devset.reclamesaude.dto;

import br.com.devset.reclamesaude.model.Reclamacao;

public record ReclamacaoExibicaoDto(
        Long id,
        UsuarioExibicaoDto usuario,
        HospitalExibicaoDto hospital,
        String descricao
) {
    public ReclamacaoExibicaoDto(Reclamacao reclamacao) {
        this(
                reclamacao.getId(),
                new UsuarioExibicaoDto(reclamacao.getUsuario()),
                new HospitalExibicaoDto(reclamacao.getHospital()),
                reclamacao.getDescricao()
        );
    }
}
