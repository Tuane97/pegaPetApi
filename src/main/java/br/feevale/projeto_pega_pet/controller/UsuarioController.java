package br.feevale.projeto_pega_pet.controller;

import br.feevale.projeto_pega_pet.controller.request.CriarUsuarioRequest;
import br.feevale.projeto_pega_pet.controller.response.UsuarioResponse;
import br.feevale.projeto_pega_pet.service.usuario.BuscarUsuarioService;
import br.feevale.projeto_pega_pet.service.usuario.CriarUsuarioService;
import br.feevale.projeto_pega_pet.service.usuario.DesativarUsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final CriarUsuarioService criarUsuarioService;

    private final BuscarUsuarioService buscarUsuarioService;

    private final DesativarUsuarioService desativarUsuarioService;

    public UsuarioController(DesativarUsuarioService desativarUsuarioService, BuscarUsuarioService buscarUsuarioService,
                             CriarUsuarioService criarUsuarioService) {
        this.criarUsuarioService = criarUsuarioService;
        this.buscarUsuarioService = buscarUsuarioService;
        this.desativarUsuarioService = desativarUsuarioService;
    }


    @PostMapping
    @ResponseStatus(CREATED)
    public void criarUsuario(@Valid @RequestBody CriarUsuarioRequest request) {
        criarUsuarioService.criar(request);
    }

    @GetMapping("/{idUsuario}")
    @ResponseStatus(OK)
    public UsuarioResponse buscarUsuario(@PathVariable Long idUsuario) {
        return buscarUsuarioService.buscar(idUsuario);
    }

    @PutMapping("/{idUsuario}")
    @ResponseStatus(OK)
    public void desativarUsuario(@PathVariable Long idUsuario) {
        desativarUsuarioService.desativar(idUsuario);
    }
}
