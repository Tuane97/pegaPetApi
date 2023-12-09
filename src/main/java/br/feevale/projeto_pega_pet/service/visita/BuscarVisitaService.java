package br.feevale.projeto_pega_pet.service.visita;

import br.feevale.projeto_pega_pet.controller.response.VisitaResponse;
import br.feevale.projeto_pega_pet.domain.Visita;
import br.feevale.projeto_pega_pet.mapper.VisitaMapper;
import br.feevale.projeto_pega_pet.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarVisitaService {

    @Autowired
    VisitaRepository visitaRepository;


    public VisitaResponse buscar(Long visitaId) {
        Visita visita = visitaRepository.findById(visitaId).get();
        return VisitaMapper.toResponse(visita);
    }
}
