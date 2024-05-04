package br.com.fiap.livraria.model.autor.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AtualizarAutorDTO(
        @Size(max = 100)
        String nome,
        @Size(max = 100)
        String biografia,
        @Email
        @Size(max = 100)
        String email) {
}
