package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.livro.Genero;

public record CadastrarLivroDTO(String titulo, String numeroIsbn, Genero genero) {
}
