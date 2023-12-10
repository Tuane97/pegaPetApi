package br.feevale.projeto_pega_pet.controller;

import br.feevale.projeto_pega_pet.controller.request.VisitaRequest;
import br.feevale.projeto_pega_pet.controller.response.VisitaResponse;
import br.feevale.projeto_pega_pet.domain.enums.TipoUsuario;
import br.feevale.projeto_pega_pet.service.visita.BuscarVisitaService;
import br.feevale.projeto_pega_pet.service.visita.EditarVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visita")
public class VisitaController {

    @Autowired
    private BuscarVisitaService buscarVisitaService;

    @Autowired
    private EditarVisitaService editarVisitaService;


    @GetMapping("/{visitaId}")
    public VisitaResponse buscarProcessoAdocao(@PathVariable Long visitaId){
        return buscarVisitaService.buscar(visitaId);
    }

    @GetMapping("/{usuarioId}/{tipoUsuario}/list")
    public Page<VisitaResponse> buscarProcessoAdocao(@PathVariable Long usuarioId, @PathVariable TipoUsuario tipoUsuario, Pageable pageable){
        return buscarVisitaService.listar(usuarioId, tipoUsuario, pageable);
    }

    @PutMapping("/{visitaId}")
    public void editarProcessoAdocao(@RequestBody VisitaRequest request, @PathVariable Long visitaId){
        editarVisitaService.editar(request, visitaId);
    }

}
