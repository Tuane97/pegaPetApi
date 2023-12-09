package br.feevale.projeto_pega_pet.mapper;

import br.feevale.projeto_pega_pet.controller.request.ProcessoAdocaoRequest;
import br.feevale.projeto_pega_pet.controller.response.ProcessoAdocaoResponse;
import br.feevale.projeto_pega_pet.domain.*;

import java.time.LocalDate;

public class ProcessoAdocaoMapper {
    public static ProcessoAdocao toEntity(ProcessoAdocaoRequest request, Ong ong, Adotante adotante, Animal animal, Visita visita) {
        return ProcessoAdocao.builder()
                .adotante(adotante)
                .ong(ong)
                .animal(animal)
                .visita(visita)
                .detalhe(request.getDetalhe())
                .dataInicio(LocalDate.now())
                .build();
    }


    public static ProcessoAdocaoResponse toResponse(ProcessoAdocao processoAdocao) {
        return ProcessoAdocaoResponse.builder()
                .id(processoAdocao.getId())
                .ong(OngMapper.toResponse(processoAdocao.getOng()))
                .adotante(AdotanteMapper.toResponse(processoAdocao.getAdotante()))
                .status(processoAdocao.getStatus())
                .animal(AnimalMapper.toResponse(processoAdocao.getAnimal()))
                .dataInicio(processoAdocao.getDataInicio())
                .detalhes(processoAdocao.getDetalhe())
                .visita(VisitaMapper.toResponse(processoAdocao.getVisita()))
        .build();
    }
}
