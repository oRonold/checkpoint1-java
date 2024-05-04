package br.com.fiap.livraria.repository;

import br.com.fiap.livraria.model.emprestimo.Emprestimo;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
