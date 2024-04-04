package br.com.fiap.livraria.repository;

import br.com.fiap.livraria.model.editora.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
