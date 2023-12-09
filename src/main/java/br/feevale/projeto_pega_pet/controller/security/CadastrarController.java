package br.feevale.projeto_pega_pet.controller.security;

import br.feevale.projeto_pega_pet.controller.request.CriarUsuarioRequest;
import br.feevale.projeto_pega_pet.service.usuario.CriarUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/cadastrar")
public class CadastrarController {

    @Autowired
    private CriarUsuarioService criarUsuarioService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void criarUsuario(@Valid @RequestBody CriarUsuarioRequest request) {
        criarUsuarioService.criar(request);
    }
}
