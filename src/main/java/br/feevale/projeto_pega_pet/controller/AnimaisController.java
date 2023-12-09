package br.feevale.projeto_pega_pet.controller;

import br.feevale.projeto_pega_pet.controller.request.AnimalRequest;
import br.feevale.projeto_pega_pet.controller.response.AnimalResponse;
import br.feevale.projeto_pega_pet.service.animal.BuscarAnimalService;
import br.feevale.projeto_pega_pet.service.animal.EditarAnimalService;
import br.feevale.projeto_pega_pet.service.animal.IncluirAnimalService;
import br.feevale.projeto_pega_pet.service.animal.ListarAnimaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimaisController {

    @Autowired
    private ListarAnimaisService listarAnimaisService;

    @Autowired
    private IncluirAnimalService incluirAnimalService;

    @Autowired
    private BuscarAnimalService buscarAnimalService;

    @Autowired
    private EditarAnimalService editarAnimalService;


    @PostMapping
    public void incluirAnimal(@RequestBody AnimalRequest request) {
        incluirAnimalService.criar(request);
    }

    @GetMapping("/{idAnimal}")
    public AnimalResponse buscarAnimal(@PathVariable Long idAnimal) {
        return buscarAnimalService.buscar(idAnimal);
    }

    @PutMapping("/{idAnimal}")
    public void editarAnimal(@RequestBody AnimalRequest request, @PathVariable Long idAnimal) {
        editarAnimalService.editar(request, idAnimal);
    }

    @GetMapping("/disponiveis")
    public Page<AnimalResponse> listarTodosDispPaginado(Pageable pageable) {
        return listarAnimaisService.listarDisp(pageable);
    }

    @GetMapping("/{ongId}/ong")
    public Page<AnimalResponse> listarPorOngPaginado(@PathVariable Long ongId, Pageable pageable) {
        return listarAnimaisService.listarPorOng(ongId, pageable);
    }

    @GetMapping("/{idAdotante}/adotante")
    public Page<AnimalResponse> listarPorAdotatePaginado(@PathVariable Long idAdotante, Pageable pageable) {
        return listarAnimaisService.listarPorAdotante(idAdotante, pageable);
    }
}
