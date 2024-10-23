package br.com.devset.reclamesaude.dto;

import jakarta.validation.constraints.NotBlank;

public record HospitalCadastroDto(

        @NotBlank(message = " O nome do Hospital é obrigatório!")//Não pode ser vazio e nem nulo
        String nome
) {
}
