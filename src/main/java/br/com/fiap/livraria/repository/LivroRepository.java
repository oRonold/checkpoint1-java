package br.com.fiap.livraria.repository;

import br.com.fiap.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
