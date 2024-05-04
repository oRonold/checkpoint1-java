package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.model.autor.dto.ListagemAutorDTO;
import br.com.fiap.livraria.model.autor.dto.ListagemUsuarioDTO;
import br.com.fiap.livraria.model.emprestimo.Emprestimo;
import br.com.fiap.livraria.model.emprestimo.dto.*;
import br.com.fiap.livraria.repository.EmprestimoRepository;
import br.com.fiap.livraria.repository.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesEmprestimoDTO> criar(@RequestBody @Valid CriarEmprestimoDTO dto, UriComponentsBuilder builder){
        var usuario = usuarioRepository.getReferenceById(dto.idUSuario());
        var emprestimo = usuario.criarEmprestimo(dto);
        usuarioRepository.save(usuario);
        repository.save(emprestimo);
        var uri = builder.path("/{id}").buildAndExpand(emprestimo.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEmprestimoDTO(emprestimo));
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

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhesEmprestimoDTO> atualizar(@RequestBody AtualizarEmprestimoDTO dto){
        var emprestimo = repository.getReferenceById(dto.codigo());
        emprestimo.atualizar(dto);
        return ResponseEntity.ok().body(new DetalhesEmprestimoDTO(emprestimo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        var emprestimo = repository.getReferenceById(id);
        repository.deleteById(emprestimo.getCodigo());
        return ResponseEntity.noContent().build();
    }

}
