package br.feevale.projeto_pega_pet.controller.security;

import br.feevale.projeto_pega_pet.controller.request.LoginRequest;
import br.feevale.projeto_pega_pet.controller.response.UsuarioResponse;
import br.feevale.projeto_pega_pet.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    @ResponseStatus(OK)
    public UsuarioResponse login(@Valid @RequestBody LoginRequest request) {
        loginService.login(request);
    }
}
