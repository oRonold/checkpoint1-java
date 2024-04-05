package br.com.fiap.livraria.model.autor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AtualizarAutorDTO(
        @NotNull
        Long codigo,
        String nome,
        String biografia,
        String email,
        LocalDate dataNascimento) {
}
