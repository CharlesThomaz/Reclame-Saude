package br.com.devset.reclamesaude.service;

import br.com.devset.reclamesaude.dto.HospitalCadastroDto;
import br.com.devset.reclamesaude.dto.HospitalExibicaoDto;
import br.com.devset.reclamesaude.exception.NaoEncontradoException;
import br.com.devset.reclamesaude.model.Hospital;
import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.repository.HospitalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;


    // Método para salvar um novo hospital
    public HospitalExibicaoDto saveHospital(HospitalCadastroDto hospitalCadastroDto) {
        Hospital hospital = new Hospital();
        BeanUtils.copyProperties(hospitalCadastroDto, hospital);
        return new HospitalExibicaoDto(hospitalRepository.save(hospital));
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
            throw new NaoEncontradoException("Hospital não encontrado");
        }
    }

    // Método para deletar um hospital por ID
    public void deleteHospital(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()) {
            hospitalRepository.deleteById(id);
        } else {
            throw new NaoEncontradoException("Hospital não encontrado");
        }
    }

    public void atualizarHospital(Hospital hospital) {
        Optional<Hospital> hospitalExiste = hospitalRepository.findById(hospital.getId());
        if (hospitalExiste.isPresent()) {
            hospitalRepository.save(hospital);
        } else {
            throw new NaoEncontradoException("Hospital não encontrado");
        }
    }

    public List<Reclamacao> listarReclamacoes(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()) {
            return hospital.get().getReclamacoes();
        } else {
            throw new NaoEncontradoException("Hospital não encontrado");
        }

    }
    public HospitalExibicaoDto buscarHospitalPorNome(String nome) {
        Optional<Hospital> hospital = hospitalRepository.buscarPorNome(nome);
        if (hospital.isPresent()) {
            return new HospitalExibicaoDto(hospital.get());
        }else {
            throw new NaoEncontradoException("Hospital não encontrado");
        }
    }

}
