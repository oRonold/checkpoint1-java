package br.com.fiap.livraria.model.editora.dto;

import br.com.fiap.livraria.model.editora.CategoriaEditora;
import jakarta.validation.constraints.NotNull;

public record AtualizarEditoraDTO(String nome, String telefone, String email, CategoriaEditora categoria) {
}
