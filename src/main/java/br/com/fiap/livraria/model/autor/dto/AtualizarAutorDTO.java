package br.com.fiap.livraria.model.autor.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AtualizarAutorDTO(Long codigo, String nome, String biografia, String email, LocalDate dataNascimento) {
}
