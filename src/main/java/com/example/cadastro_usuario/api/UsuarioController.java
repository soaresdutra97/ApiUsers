package com.example.cadastro_usuario.api;

import com.example.cadastro_usuario.Business.UsuarioService;
import com.example.cadastro_usuario.api.request.UsuarioRequestDTO;
import com.example.cadastro_usuario.api.response.UsuarioResponseDTO;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<UsuarioResponseDTO> gravaDadosUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return ResponseEntity.ok(usuarioService.gravaUsuarios(usuarioRequestDTO));
    }

    @PutMapping()
    public ResponseEntity<UsuarioResponseDTO> atualizaDadosUsuarios(@RequestParam ("id") String id, @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return ResponseEntity.ok(usuarioService.atualizaCadastro(usuarioRequestDTO, id));
    }

    @GetMapping()
    public ResponseEntity<UsuarioResponseDTO> buscaUsuarioPorEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(usuarioService.buscaDadosUsuario(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaDadosUsuario(@RequestParam ("email") String email){
        usuarioService.deletaDadosUsuario(email);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioResponseDTO>> buscaTodosUsuarios(){
        return ResponseEntity.ok(usuarioService.buscaTodosUsuarios());
    }

}