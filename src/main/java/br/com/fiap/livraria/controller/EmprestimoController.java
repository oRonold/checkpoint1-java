package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import br.com.fiap.livraria.model.emprestimo.dto.*;
import br.com.fiap.livraria.repository.EmprestimoRepository;
import br.com.fiap.livraria.service.EmprestimoLivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private EmprestimoLivroService service;

    @PostMapping("/{idUsuario}/livro/{idLivro}")
    @Transactional
    public ResponseEntity<DetalhesEmprestimoUsuarioDTO> criar(@PathVariable Long idLivro, @PathVariable Long idUsuario, @RequestBody @Valid CriarEmprestimoDTO dto, UriComponentsBuilder builder){
        var emprestimo = service.criarEmprestimo(idLivro, idUsuario, dto);
        var uri = builder.path("/{id}").buildAndExpand(emprestimo.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEmprestimoUsuarioDTO(emprestimo));
    }


    @GetMapping
    public ResponseEntity<Page<ListagemEmprestimoDTO>> listar(@PageableDefault(sort = {"dataEmprestimo"}) Pageable pageable) {
        var page = repository.findAll(pageable).map(ListagemEmprestimoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesEmprestimoUsuarioDTO> buscarPorId(@PathVariable Long id){
        var emprestimo = repository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetalhesEmprestimoUsuarioDTO(emprestimo));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesEmprestimoUsuarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarEmprestimoDTO dto){
        var emprestimo = repository.getReferenceById(id);
        emprestimo.atualizar(dto);
        return ResponseEntity.ok().body(new DetalhesEmprestimoUsuarioDTO(emprestimo));
    }

    @PutMapping("/{idEmprestimo}/livro/{idLivro}")
    @Transactional
    public ResponseEntity<DetalhesEmprestimoUsuarioDTO> addLivroEmprestimo(@PathVariable Long idEmprestimo, @PathVariable Long idLivro){
        var emprestimo = service.adicionarMaisLivrosAoEmprestimo(idLivro, idEmprestimo);
        return ResponseEntity.ok().body(new DetalhesEmprestimoUsuarioDTO(emprestimo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> devolverEmprestimo(@PathVariable Long id){
        var emprestimo = repository.getReferenceById(id);
        emprestimo.setStatus(StatusEmprestimo.valueOf("DEVOLVIDO"));
        return ResponseEntity.noContent().build();
    }

}
