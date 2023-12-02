package br.feevale.projeto_pega_pet.controller.response;

import br.feevale.projeto_pega_pet.domain.Animal;
import br.feevale.projeto_pega_pet.domain.Contato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private Long idUsuario;
    private String nome;
    private String email;
    private String foto;
    private List<Contato> contatos;
    private List<Animal> animais;

}
