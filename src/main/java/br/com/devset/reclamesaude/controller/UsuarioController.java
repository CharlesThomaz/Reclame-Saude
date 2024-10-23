package br.com.devset.reclamesaude.controller;

import br.com.devset.reclamesaude.dto.UsuarioCadastroDto;
import br.com.devset.reclamesaude.dto.UsuarioExibicaoDto;
import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.model.Usuario;
import br.com.devset.reclamesaude.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDto> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto cadastrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        return usuarioService.cadastraUsuario(usuarioCadastroDto);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
    }

    @GetMapping("/listarreclamacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Reclamacao> buscarReclamacoes(@PathVariable Long id) {
        try {
            return usuarioService.listarReclamacoes(id);
        } catch (RuntimeException e) {
            // Retorna 404 se o usuário não for encontrado
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto buscarPorId(@PathVariable Long id) {
        return usuarioService.buscaUsuarioPorId(id);
    }
}
