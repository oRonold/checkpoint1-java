package br.com.fiap.livraria.repository;

import br.com.fiap.livraria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
