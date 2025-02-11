package br.com.devset.reclamesaude.controller;

import br.com.devset.reclamesaude.dto.ReclamacaoCadastroDto;
import br.com.devset.reclamesaude.dto.ReclamacaoExibicaoDto;
import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.repository.ReclamacaoRepository;
import br.com.devset.reclamesaude.service.ReclamacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamacao")
public class ReclamacaoController {

    @Autowired
    ReclamacaoService reclamacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReclamacaoExibicaoDto cadastrarReclamacao(@RequestBody @Valid ReclamacaoCadastroDto reclamacaoCadastroDto) {
        return reclamacaoService.cadastrarReclamacao(reclamacaoCadastroDto);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ReclamacaoExibicaoDto> listarReclamacao(Pageable paginacao) {
        return reclamacaoService.listarReclamacao(paginacao);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReclamacaoExibicaoDto getReclamacao(@PathVariable Long id) {
        return reclamacaoService.getReclamacao(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizarReclamacao(@RequestBody Reclamacao reclamacao) {
        reclamacaoService.atualizarReclamacao(reclamacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerReclamacao(@PathVariable Long id) {
        reclamacaoService.excluirReclamacao(id);
    }


}
