package br.com.devset.reclamesaude.service;

import br.com.devset.reclamesaude.dto.HospitalExibicaoDto;
import br.com.devset.reclamesaude.dto.ReclamacaoExibicaoDto;
import br.com.devset.reclamesaude.dto.UsuarioExibicaoDto;
import br.com.devset.reclamesaude.model.Hospital;
import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.repository.HospitalRepository;
import br.com.devset.reclamesaude.repository.ReclamacaoRepository;
import br.com.devset.reclamesaude.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReclamacaoService {

    @Autowired
    ReclamacaoRepository reclamacaoRepository;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    UsuarioRepository usuarioRepository;


    public ReclamacaoExibicaoDto getReclamacao(Long id) {
        Optional<Reclamacao> reclamacao = reclamacaoRepository.findById(id);
        if (reclamacao.isPresent()) {
            return new ReclamacaoExibicaoDto(reclamacao.get());
        } else {
            throw new RuntimeException("Reclamacao nao encontrada");
        }
    }

    public void cadastrarReclamacao(Reclamacao reclamacao) {
        reclamacaoRepository.save(reclamacao);
    }

    public List<ReclamacaoExibicaoDto> listarReclamacao() {
        List<ReclamacaoExibicaoDto> novaLista = new ArrayList<>();
        List<Reclamacao> listaReclamacao = reclamacaoRepository.findAll();

        if (!listaReclamacao.isEmpty()) {
            for (Reclamacao reclamacao : listaReclamacao) {
                novaLista.add(new ReclamacaoExibicaoDto(reclamacao));
            }
        }

        return novaLista;
    }


    public void excluirReclamacao(Long id) {
        Optional<Reclamacao> reclamacao = reclamacaoRepository.findById(id);
        if (reclamacao.isPresent()) {
            reclamacaoRepository.delete(reclamacao.get());
        } else {
            throw new RuntimeException("Reclamacao nao encontrada");
        }
    }

    public void atualizarReclamacao(Reclamacao reclamacao) {
        Optional<Reclamacao> reclamacaoExistente = reclamacaoRepository.findById(reclamacao.getId());
        if (reclamacaoExistente.isPresent()) {
            reclamacaoRepository.save(reclamacao);
        } else {
            throw new RuntimeException("Reclamacao nao encontrada");
        }
    }
}
