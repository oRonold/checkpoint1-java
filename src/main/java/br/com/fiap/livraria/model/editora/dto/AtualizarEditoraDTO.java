package br.com.fiap.livraria.model.editora.dto;

import br.com.fiap.livraria.model.editora.CategoriaEditora;
import jakarta.validation.constraints.NotNull;

public record AtualizarEditoraDTO(
        @NotNull
        Long codigo,
        String nome, String telefone, String email, CategoriaEditora categoria) {
}
