package br.com.devset.reclamesaude.service;

import br.com.devset.reclamesaude.model.Hospital;
import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;


    // Método para salvar um novo hospital
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    // Método para obter todos os hospitais
    public List<Hospital> getAllHospitais() {
        return hospitalRepository.findAll();
    }

    // Método para obter um hospital por ID
    public Hospital getHospitalById(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()) {
            return hospital.get();
        } else {
            throw new RuntimeException("Hospital não encontrado");
        }
    }

    // Método para deletar um hospital por ID
    public void deleteHospital(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()) {
            hospitalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Hospital não encontrado");
        }
    }

    public void atualizarHospital(Hospital hospital) {
        Optional<Hospital> hospitalExiste = hospitalRepository.findById(hospital.getId());
        if (hospitalExiste.isPresent()) {
            hospitalRepository.save(hospital);
        } else {
            throw new RuntimeException("Hospital não encontrado");
        }
    }

    public List<Reclamacao> listarReclamacoes(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()) {
            return hospital.get().getReclamacoes();
        } else {
            throw new RuntimeException("Hospital não encontrado");
        }

    }

}
