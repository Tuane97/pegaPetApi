package br.feevale.projeto_pega_pet.controller.security;

import br.feevale.projeto_pega_pet.controller.request.LoginRequest;
import br.feevale.projeto_pega_pet.controller.response.UsuarioResponse;
import br.feevale.projeto_pega_pet.service.usuario.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping
    public UsuarioResponse login(@Valid @RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}
