package br.com.fiap.livraria.repository;

import br.com.fiap.livraria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
