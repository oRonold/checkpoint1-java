package br.com.fiap.livraria.model.autor.dto;

import java.time.LocalDate;

public record CadastrarAutorDTO(String nome, String biografia, String email, LocalDate dataNascimento) {
}
