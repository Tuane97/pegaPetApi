package br.feevale.projeto_pega_pet.controller;

import br.feevale.projeto_pega_pet.controller.response.UsuarioResponse;
import br.feevale.projeto_pega_pet.service.usuario.BuscarUsuarioService;
import br.feevale.projeto_pega_pet.service.usuario.DesativarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private DesativarUsuarioService desativarUsuarioService;



    @GetMapping("/{idUsuario}")
    @ResponseStatus(OK)
    public UsuarioResponse buscarUsuarioPorId(@PathVariable Long idUsuario) {
        return buscarUsuarioService.buscar(idUsuario);
    }

    @GetMapping("/buscar")
    @ResponseStatus(OK)
    public Page<UsuarioResponse> buscarUsuarioPorNome(@RequestParam("text") String text, Pageable pageable) {
        return buscarUsuarioService.buscarPorNome(text, pageable);
    }

    @GetMapping("/buscar/ongs")
    @ResponseStatus(OK)
    public Page<UsuarioResponse> buscarUsuarioPorNome(Pageable pageable) {
        return buscarUsuarioService.listarOngs(pageable);
    }

    @PutMapping("/{idUsuario}/desativar")
    @ResponseStatus(OK)
    public void desativarUsuario(@PathVariable Long idUsuario) {
        desativarUsuarioService.desativar(idUsuario);
    }
}
