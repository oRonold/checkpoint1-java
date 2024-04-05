package br.com.fiap.livraria.model.usuario.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarUsuarioDTO(
        @NotNull
        Long codigo,
        String nome, String email, String senha) {
}
