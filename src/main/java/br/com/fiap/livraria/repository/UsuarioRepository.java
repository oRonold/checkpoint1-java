package br.com.fiap.livraria.repository;

import br.com.fiap.livraria.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
