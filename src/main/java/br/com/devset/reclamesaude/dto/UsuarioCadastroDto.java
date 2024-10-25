package br.com.devset.reclamesaude.dto;

import br.com.devset.reclamesaude.model.PapeisDoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record UsuarioCadastroDto(

        @NotBlank(message = "O nome do Usuário é obrigatório!") // Não pode ser vazio e nem nulo
        String nome,

        @NotBlank(message = "O email é obrigatório!")
        @Email(message = "O email está com formato inválido!")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 6, max = 10, message = "A senha deve conter entre 6 e 10 caracteres!")
        String senha,

        @NotNull(message = "Seu papel é obrigatório para definir suas permissões de acesso!")
        PapeisDoUsuario papeisDoUsuario
) {}
