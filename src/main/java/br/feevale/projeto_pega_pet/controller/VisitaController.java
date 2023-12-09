package br.feevale.projeto_pega_pet.controller;

import br.feevale.projeto_pega_pet.controller.request.VisitaRequest;
import br.feevale.projeto_pega_pet.controller.response.VisitaResponse;
import br.feevale.projeto_pega_pet.service.visita.BuscarVisitaService;
import br.feevale.projeto_pega_pet.service.visita.EditarVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/{visitaId}")
    public void editarProcessoAdocao(@RequestBody VisitaRequest request, @PathVariable Long visitaId){
        editarVisitaService.editar(request, visitaId);
    }

}
