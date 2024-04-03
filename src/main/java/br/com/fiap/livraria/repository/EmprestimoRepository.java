package br.com.fiap.livraria.repository;

import br.com.fiap.livraria.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
