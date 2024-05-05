package br.com.fiap.livraria.model.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record AtualizarUsuarioDTO(
        @Size(max = 100)
        String nome,
        @Size(max = 100)
        @Email
        String email,
        @Size(max = 10)
        String senha) {
}
