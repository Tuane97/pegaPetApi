package br.feevale.projeto_pega_pet.service.animal;

import br.feevale.projeto_pega_pet.controller.response.AnimalResponse;
import br.feevale.projeto_pega_pet.domain.Adotante;
import br.feevale.projeto_pega_pet.domain.Animal;
import br.feevale.projeto_pega_pet.domain.Ong;
import br.feevale.projeto_pega_pet.mapper.AnimalMapper;
import br.feevale.projeto_pega_pet.repository.AdotanteRepository;
import br.feevale.projeto_pega_pet.repository.AnimalRepository;
import br.feevale.projeto_pega_pet.repository.OngRepository;
import br.feevale.projeto_pega_pet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarAnimaisService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AdotanteRepository adotanteRepository;

    @Autowired
    private OngRepository ongRepository;

    public Page<AnimalResponse> listarDisp(Pageable pageable) {
        Page<Animal> animais = animalRepository.findAllByDisponivel(true, pageable);


        System.out.println(animais.toString());
        return animais.map(animal -> {
            AnimalResponse response = AnimalMapper.toResponse(animal);
            return response;
        });
    }

    public Page<AnimalResponse> listarPorOng(Long usuarioId, Pageable pageable) {
        Ong ong = ongRepository.findByUsuarioId(usuarioId).get();
        Page<Animal> animais = animalRepository.findAllByOngIdAndDisponivel(ong.getId(), true, pageable);
        return animais.map(AnimalMapper::toResponse);
    }

    public Page<AnimalResponse> listarPorAdotante(Long usuarioId, Pageable pageable) {
        Adotante adotante = adotanteRepository.findByUsuarioId(usuarioId).get();
        Page<Animal> animais = animalRepository.findAllByAdotanteId(adotante.getId(), pageable);
        return animais.map(AnimalMapper::toResponse);
    }
}
