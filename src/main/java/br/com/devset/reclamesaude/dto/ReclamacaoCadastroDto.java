package br.com.devset.reclamesaude.dto;

import br.com.devset.reclamesaude.model.Hospital;
import br.com.devset.reclamesaude.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReclamacaoCadastroDto(
        @NotNull(message = " O id do usuário é obrigatório!")//Não pode ser vazio e nem nulo
        Usuario usuario,

        @NotNull(message = " O id do hospital é obrigatório!")//Não pode ser vazio e nem nulo
        Hospital hospital,

        @NotBlank(message = " O mensagem obrigatório!")//Não pode ser vazio e nem nulo
        String descricao
) {

}
