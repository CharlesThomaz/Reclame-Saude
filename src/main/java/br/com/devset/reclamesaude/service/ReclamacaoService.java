package br.com.devset.reclamesaude.service;

import br.com.devset.reclamesaude.dto.ReclamacaoCadastroDto;
import br.com.devset.reclamesaude.dto.ReclamacaoExibicaoDto;
import br.com.devset.reclamesaude.exception.NaoEncontradoException;
import br.com.devset.reclamesaude.model.Hospital;
import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.model.Usuario;
import br.com.devset.reclamesaude.repository.HospitalRepository;
import br.com.devset.reclamesaude.repository.ReclamacaoRepository;
import br.com.devset.reclamesaude.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
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
            throw new NaoEncontradoException("Reclamacao nao encontrada");
        }
    }

    public ReclamacaoExibicaoDto cadastrarReclamacao(ReclamacaoCadastroDto reclamacaoCadastroDto) {
        // Carregar o usuário completo pelo ID
        Usuario usuario = usuarioRepository.findById(reclamacaoCadastroDto.usuario().getId())
                .orElseThrow(() -> new NaoEncontradoException("Usuário não encontrado"));

        // Carregar o hospital completo pelo ID
        Hospital hospital = hospitalRepository.findById(reclamacaoCadastroDto.hospital().getId())
                .orElseThrow(() -> new NaoEncontradoException("Hospital não encontrado"));

        // Criar a entidade Reclamacao e definir os dados completos
        Reclamacao reclamacao = new Reclamacao();
        BeanUtils.copyProperties(reclamacaoCadastroDto, reclamacao);
        reclamacao.setUsuario(usuario); // Define o usuário completo
        reclamacao.setHospital(hospital); // Define o hospital completo

        // Salvar a reclamacao e retornar o DTO de exibição
        reclamacaoRepository.save(reclamacao);
        return new ReclamacaoExibicaoDto(reclamacao);
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
            throw new NaoEncontradoException("Reclamacao nao encontrada");
        }
    }

    public void atualizarReclamacao(Reclamacao reclamacao) {
        Optional<Reclamacao> reclamacaoExistente = reclamacaoRepository.findById(reclamacao.getId());
        if (reclamacaoExistente.isPresent()) {
            reclamacaoRepository.save(reclamacao);
        } else {
            throw new NaoEncontradoException("Reclamacao nao encontrada");
        }
    }
}
