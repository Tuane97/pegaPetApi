package br.feevale.projeto_pega_pet.service.processoAdocao;

import br.feevale.projeto_pega_pet.controller.request.ProcessoAdocaoRequest;
import br.feevale.projeto_pega_pet.domain.*;
import br.feevale.projeto_pega_pet.domain.enums.StatusProcessoAdocao;
import br.feevale.projeto_pega_pet.mapper.ContatoMapper;
import br.feevale.projeto_pega_pet.mapper.ProcessoAdocaoMapper;
import br.feevale.projeto_pega_pet.repository.*;
import br.feevale.projeto_pega_pet.service.visita.CriarVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriarProcessoAdocaoService {

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private AdotanteRepository adotanteRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProcessoAdocaoRepository processoAdocaoRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private CriarVisitaService criarVisitaService;


    public void criar(ProcessoAdocaoRequest request) {
        Ong ong = ongRepository.findById(request.getOngId()).get();
        Adotante adotante = adotanteRepository.findById(request.getAdotanteId()).get();
        Animal animal = animalRepository.findById(request.getAnimalId()).get();
        Visita visita = criarVisitaService.criar(request.getData(), request.getHora());
        ProcessoAdocao processoAdocao = ProcessoAdocaoMapper.toEntity(request, ong, adotante, animal, visita);
        processoAdocao.setStatus(StatusProcessoAdocao.INICIADA);
        processoAdocao.setCdStatus(StatusProcessoAdocao.INICIADA.codigo);

        List<Contato> listaContato = adotante.getUsuario().getContatos();

        if (!verificaContatoExistente(request.getContato(), listaContato)){
            Contato contato = ContatoMapper.toEntity(request.getContato(), adotante.getUsuario());
            adotante.getUsuario().getContatos().add(contato);
            contatoRepository.save(contato);
        }
        processoAdocaoRepository.save(processoAdocao);

    }

    public boolean verificaContatoExistente(String contato, List<Contato> listaContatos){
        for (Contato item : listaContatos){
            if (item.getNrContato().equals(contato)){
                return true;
            }
        }

        return false;
    }


}
