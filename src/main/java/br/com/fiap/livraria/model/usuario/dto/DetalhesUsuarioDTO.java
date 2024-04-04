package br.com.fiap.livraria.model.usuario.dto;

import br.com.fiap.livraria.model.usuario.Usuario;

public record DetalhesUsuarioDTO(Long codigo, String nome, String email) {

    public DetalhesUsuarioDTO(Usuario usuario){
        this(usuario.getCodigo(), usuario.getNome(), usuario.getEmail());
    }

}
