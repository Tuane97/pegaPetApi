package br.feevale.projeto_pega_pet.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String senha;
}
