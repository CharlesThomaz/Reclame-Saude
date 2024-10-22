package br.com.devset.reclamesaude.service;

import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.model.Usuario;
import br.com.devset.reclamesaude.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastraUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);    }

    public List<Usuario> listar() {
            return usuarioRepository.findAll();    }

    public Usuario buscaUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        }else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }
    public void excluirUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
        }else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }
    public void atualizar(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuario.getId());
        if (usuarioExistente.isPresent()) {
            usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado com ID: " + usuario.getId());
        }
    }
    public List<Reclamacao> listarReclamacoes(Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if (usuario.isPresent()) {
            List<Reclamacao> reclamacoes = usuario.get().getReclamacoes();
            return (reclamacoes != null) ? reclamacoes : new ArrayList<>(); // Retorna lista vazia se reclamacoes for null
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }


}
