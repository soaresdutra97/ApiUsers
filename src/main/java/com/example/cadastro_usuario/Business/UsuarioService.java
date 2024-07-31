package com.example.cadastro_usuario.Business;

import com.example.cadastro_usuario.api.converter.UsuarioConverter;
import com.example.cadastro_usuario.api.request.UsuarioRequestDTO;
import com.example.cadastro_usuario.api.response.UsuarioResponseDTO;
import com.example.cadastro_usuario.infrastructure.entities.UsuarioEntity;
import com.example.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioEntity salvaUsuario(UsuarioEntity usuarioEntity){
        return usuarioRepository.saveAndFlush(usuarioEntity);
    }

    public UsuarioResponseDTO gravaUsuarios(UsuarioRequestDTO usuarioRequestDTO){
        try{
            UsuarioEntity usuarioEntity = salvaUsuario(usuarioConverter.paraUsuarioEntity(usuarioRequestDTO));
            return usuarioConverter.paraUsuarioResponseDto(usuarioEntity);
        } catch (Exception e){
            throw new RuntimeException("Erro ao gravar dados de usuário");
        }
    }

    public UsuarioResponseDTO buscaDadosUsuario(String email){
        return usuarioConverter.paraUsuarioResponseDto(usuarioRepository.findByEmail(email));
    }

    public void deletaDadosUsuario(String email){
        usuarioRepository.deleteByEmail(email);
    }

    public List<UsuarioResponseDTO> buscaTodosUsuarios(){
        return usuarioConverter.paraUsuarioResponseDtoList(usuarioRepository.findAll());
    }

}

