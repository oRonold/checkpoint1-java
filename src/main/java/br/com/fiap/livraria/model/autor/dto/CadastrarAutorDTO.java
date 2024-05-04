package br.com.fiap.livraria.model.autor.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CadastrarAutorDTO(
        @NotBlank
        String nome,
        @NotBlank
        String biografia,
        @NotBlank
        @Email
        String email,
        @NotNull
        @Past
        LocalDate dataNascimento) {
}
