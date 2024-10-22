package br.com.devset.reclamesaude.dto;

import br.com.devset.reclamesaude.model.Hospital;

public record HospitalExibicaoDto (
        Long id,
        String nome
){
    public HospitalExibicaoDto (Hospital hospital){
        this(hospital.getId(), hospital.getNome());
    }
}
