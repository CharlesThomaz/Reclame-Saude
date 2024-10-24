package br.com.devset.reclamesaude.dto;

import br.com.devset.reclamesaude.model.Reclamacao;

import java.time.LocalDateTime;

public record ReclamacaoExibicaoDto(
        Long id,
        UsuarioExibicaoDto usuario,
        HospitalExibicaoDto hospital,
        LocalDateTime dataReclamacao,
        String descricao
) {
    public ReclamacaoExibicaoDto(Reclamacao reclamacao) {
        this(
                reclamacao.getId(),
                new UsuarioExibicaoDto(reclamacao.getUsuario()),
                new HospitalExibicaoDto(reclamacao.getHospital()),
                reclamacao.getDataReclamacao(),
                reclamacao.getDescricao()
        );
    }
}
