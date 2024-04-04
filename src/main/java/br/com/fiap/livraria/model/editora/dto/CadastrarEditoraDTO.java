package br.com.fiap.livraria.model.editora.dto;

import br.com.fiap.livraria.model.editora.CategoriaEditora;

public record CadastrarEditoraDTO(String nome, String telefone, String email, CategoriaEditora categoria) {
}
