package br.com.fiap.livraria.model.editora.dto;

import br.com.fiap.livraria.model.editora.CategoriaEditora;

public record AtualizarEditoraDTO(Long codigo, String nome, String telefone, String email, CategoriaEditora categoria) {
}
