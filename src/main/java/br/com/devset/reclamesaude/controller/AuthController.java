package br.com.devset.reclamesaude.controller;

import br.com.devset.reclamesaude.dto.UsuarioCadastroDto;
import br.com.devset.reclamesaude.dto.UsuarioExibicaoDto;
import br.com.devset.reclamesaude.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioCadastroDto usuarioCadastroDto) {
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            usuarioCadastroDto.email(),
                            usuarioCadastroDto.senha());

            Authentication authentication = authenticationManager.authenticate(
                    usernamePasswordAuthenticationToken);

            // Retornar uma mensagem de sucesso ou um token de autenticação
            return ResponseEntity.ok("Login successful");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        UsuarioExibicaoDto usuarioSalvo = null;
        usuarioSalvo = usuarioService.cadastraUsuario(usuarioCadastroDto);
        return usuarioSalvo;
    }
}
