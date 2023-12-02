package br.feevale.projeto_pega_pet.service;

import br.feevale.projeto_pega_pet.controller.request.LoginRequest;
import br.feevale.projeto_pega_pet.domain.Usuario;
import br.feevale.projeto_pega_pet.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Base64;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail());
        String senha = Base64.getDecoder().decode(usuario.getSenha()).toString();
        if(!senha.equals(request.getSenha())){
            throw new ResponseStatusException(BAD_REQUEST, "Usuário ou senha incorretos");
        }
    }
}
