package br.com.devset.reclamesaude.controller;

import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.service.ReclamacaoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void cadastrarReclamacao(@RequestBody Reclamacao reclamacao) {
        reclamacaoService.cadastrarReclamacao(reclamacao);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Reclamacao> listarReclamacao() {
        return reclamacaoService.listarReclamacao();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reclamacao getReclamacao(@PathVariable Long id) {
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
