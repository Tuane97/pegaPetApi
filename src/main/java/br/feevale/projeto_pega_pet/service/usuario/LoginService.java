package br.feevale.projeto_pega_pet.service.usuario;

import br.feevale.projeto_pega_pet.controller.request.LoginRequest;
import br.feevale.projeto_pega_pet.controller.response.UsuarioResponse;
import br.feevale.projeto_pega_pet.domain.Usuario;
import br.feevale.projeto_pega_pet.mapper.UsuarioMapper;
import br.feevale.projeto_pega_pet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Base64;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public UsuarioResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Usuário ou senha incorretos"));;
        String senha = new String(Base64.getDecoder().decode(usuario.getSenha()));
        if(!senha.equals(request.getSenha())){
            throw new ResponseStatusException(BAD_REQUEST, "Usuário ou senha incorretos");
        }

        return UsuarioMapper.toResponse(usuario);
    }
}
