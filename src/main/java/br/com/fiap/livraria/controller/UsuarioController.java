package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.model.usuario.dto.ListagemUsuarioDTO;
import br.com.fiap.livraria.model.usuario.Usuario;
import br.com.fiap.livraria.model.usuario.dto.AtualizarUsuarioDTO;
import br.com.fiap.livraria.model.usuario.dto.CadastrarUsuarioDTO;
import br.com.fiap.livraria.model.usuario.dto.DetalhesUsuarioDTO;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ListagemUsuarioDTO> cadastrar(@RequestBody @Valid CadastrarUsuarioDTO dto, UriComponentsBuilder builder){
        var usuario = new Usuario(dto);
        repository.save(usuario);
        var uri = builder.path("/{id}").buildAndExpand(usuario.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new ListagemUsuarioDTO(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemUsuarioDTO>> listar(@PageableDefault(sort = {"nome"}) Pageable pageable){
        var page = repository.findAll(pageable).map(ListagemUsuarioDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesUsuarioDTO> buscarPorId(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetalhesUsuarioDTO(usuario));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioDTO dto){
        var usuario = repository.getReferenceById(id);
        usuario.atualizar(dto);
        return ResponseEntity.ok().body(new DetalhesUsuarioDTO(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        repository.deleteById(usuario.getCodigo());
        return ResponseEntity.noContent().build();
    }

}
