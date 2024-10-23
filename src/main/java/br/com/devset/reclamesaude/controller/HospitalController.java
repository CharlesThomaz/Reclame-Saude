package br.com.devset.reclamesaude.controller;


import br.com.devset.reclamesaude.dto.HospitalCadastroDto;
import br.com.devset.reclamesaude.dto.HospitalExibicaoDto;
import br.com.devset.reclamesaude.model.Hospital;
import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.service.HospitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital") // Define a URL base para o controller
public class HospitalController {

    @Autowired
    HospitalService hospitalService;


    // Endpoint para criar um novo hospital
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HospitalExibicaoDto createHospital(@RequestBody @Valid HospitalCadastroDto hospitalCadastroDto) {
        return hospitalService.saveHospital(hospitalCadastroDto);
    }

    // Endpoint para obter todos os hospitais
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Hospital> getAllHospitais() {
        return hospitalService.getAllHospitais();
    }

    // Endpoint para obter um hospital por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Hospital getHospitalById(@PathVariable Long id) {
        return hospitalService.getHospitalById(id);
    }

    // Endpoint para deletar um hospital por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateHospital(@RequestBody Hospital hospital) {
        hospitalService.atualizarHospital(hospital);
    }

    @GetMapping("/listarreclamacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Reclamacao> listarReclamacoes(@PathVariable Long id) {
        return hospitalService.listarReclamacoes(id);
    }
}
