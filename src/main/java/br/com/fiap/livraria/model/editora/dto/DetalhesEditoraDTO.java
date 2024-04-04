package br.com.fiap.livraria.model.editora.dto;

import br.com.fiap.livraria.model.editora.CategoriaEditora;
import br.com.fiap.livraria.model.editora.Editora;

public record DetalhesEditoraDTO(Long codigo, String nome, String telefone, String email, CategoriaEditora categoria) {

    public DetalhesEditoraDTO(Editora editora){
        this(editora.getCodigo(), editora.getNome(), editora.getTelefone(), editora.getEmail(), editora.getCategoria());
    }

}
