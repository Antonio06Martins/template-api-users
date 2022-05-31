package br.com.antonio.template.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse salva(@Valid @RequestBody UsuarioRequest usuarioRequest) {

        Usuario usuario = usuarioRepository.save(usuarioRequest.toModel());

        return new UsuarioResponse(usuario);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponse> busca(@PathVariable Long id) {

        var usuario = usuarioRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "id não encontrado"));

        return ResponseEntity.ok(new UsuarioResponse(usuario));

//        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
//        if (usuarioOptional.isPresent()) {
//            return ResponseEntity.ok(new UsuarioResponse(usuarioOptional.get()));
//        }
//        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/idade/entre/{idadeInicial}/ate/{idadeFinal}")
    public ResponseEntity<List<UsuarioResponse>> buscaEntreIdade(@PathVariable Integer idadeInicial, @PathVariable Integer idadeFinal) {

        List<Usuario> usuario = new ArrayList<>(usuarioRepository.findAllByIdadeBetween(idadeInicial, idadeFinal));

        return ResponseEntity.ok().body(usuario.stream()
                .map(UsuarioResponse::new)
                .collect(Collectors.toList()));
    }
}
