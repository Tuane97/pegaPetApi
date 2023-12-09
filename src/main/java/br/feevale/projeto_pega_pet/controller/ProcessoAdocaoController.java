package br.feevale.projeto_pega_pet.controller;

import br.feevale.projeto_pega_pet.controller.request.EditarProcessoAdocaoRequest;
import br.feevale.projeto_pega_pet.controller.request.ProcessoAdocaoRequest;
import br.feevale.projeto_pega_pet.controller.response.ProcessoAdocaoResponse;
import br.feevale.projeto_pega_pet.service.processoAdocao.BuscarProcessoAdocaoService;
import br.feevale.projeto_pega_pet.service.processoAdocao.CriarProcessoAdocaoService;
import br.feevale.projeto_pega_pet.service.processoAdocao.EditarProcessoAdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/processoAdocao")
public class ProcessoAdocaoController {

    @Autowired
    private CriarProcessoAdocaoService criarProcessoAdocaoService;

    @Autowired
    private BuscarProcessoAdocaoService buscarProcessoAdocaoService;

    @Autowired
    private EditarProcessoAdocaoService editarProcessoAdocaoService;

    @PostMapping
    public void criarProcessoAdocao(@RequestBody ProcessoAdocaoRequest request){
        criarProcessoAdocaoService.criar(request);
    }

    @GetMapping("/{processoId}")
    public ProcessoAdocaoResponse buscarProcessoAdocao(@PathVariable Long processoId){
        return buscarProcessoAdocaoService.buscar(processoId);
    }

    @PutMapping("/{processoId}")
    public void editarProcessoAdocao(@RequestBody EditarProcessoAdocaoRequest request, @PathVariable Long processoId){
        editarProcessoAdocaoService.editar(request, processoId);
    }

    @GetMapping("/{ongId}/ong")
    public Page<ProcessoAdocaoResponse> listarProcessoAdocaoporOng(@PathVariable Long ongId, Pageable pageable){
        return buscarProcessoAdocaoService.listarPorOng(ongId, pageable);
    }

    @GetMapping("/{adotanteId}/adotante")
    public Page<ProcessoAdocaoResponse> listarProcessoAdocaoporOAdotante(@PathVariable Long adotanteId, Pageable pageable){
        return buscarProcessoAdocaoService.listarPorAdotante(adotanteId, pageable);
    }
}
