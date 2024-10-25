package br.com.devset.reclamesaude.service;

import br.com.devset.reclamesaude.dto.HospitalExibicaoDto;
import br.com.devset.reclamesaude.dto.UsuarioCadastroDto;
import br.com.devset.reclamesaude.dto.UsuarioExibicaoDto;
import br.com.devset.reclamesaude.exception.NaoEncontradoException;
import br.com.devset.reclamesaude.model.Hospital;
import br.com.devset.reclamesaude.model.Reclamacao;
import br.com.devset.reclamesaude.model.Usuario;
import br.com.devset.reclamesaude.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto cadastraUsuario(UsuarioCadastroDto usuarioCadastroDto) {
        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(senhaCriptografada);
        return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
    }

    public List<UsuarioExibicaoDto> listar() {
        List<UsuarioExibicaoDto> novalista = new ArrayList<>();
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario usuario : usuarios) {
            novalista.add(new UsuarioExibicaoDto(usuario));
        }
        return novalista;
    }

    public UsuarioExibicaoDto buscaUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return new UsuarioExibicaoDto(usuario.get());
        } else {
            throw new NaoEncontradoException("Usuario não encontrado");
        }
    }

    public void excluirUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
        } else {
            throw new NaoEncontradoException("Usuario não encontrado");
        }
    }

    public void atualizar(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuario.getId());
        if (usuarioExistente.isPresent()) {
            usuarioRepository.save(usuario);
        } else {
            throw new NaoEncontradoException("Usuário não encontrado com ID: " + usuario.getId());
        }
    }

    public List<Reclamacao> listarReclamacoes(Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if (usuario.isPresent()) {
            List<Reclamacao> reclamacoes = usuario.get().getReclamacoes();
            return (reclamacoes != null) ? reclamacoes : new ArrayList<>(); // Retorna lista vazia se reclamacoes for null
        } else {
            throw new NaoEncontradoException("Usuário não encontrado");
        }
    }

    public UsuarioExibicaoDto buscarUsuarioPorNome(String nome) {
        Optional<Usuario> usuario = usuarioRepository.buscarPorNome(nome);
        if (usuario.isPresent()) {
            return new UsuarioExibicaoDto(usuario.get());
        }else {
            throw new NaoEncontradoException("Usuario não encontrado");
        }
    }
//    public UsuarioExibicaoDto buscarUsuarioPorEmail(String email) {
//        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
//        if (usuario.isPresent()) {
//            return new UsuarioExibicaoDto(usuario.get());
//        }else{
//            throw new NaoEncontradoException("Usuario não encontrado");
//        }
//    }

}
