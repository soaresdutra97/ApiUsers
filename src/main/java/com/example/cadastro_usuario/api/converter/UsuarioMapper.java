package com.example.cadastro_usuario.api.converter;

import com.example.cadastro_usuario.api.request.UsuarioRequestDTO;
import com.example.cadastro_usuario.api.response.UsuarioResponseDTO;
import com.example.cadastro_usuario.infrastructure.entities.UsuarioEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioResponseDTO paraUsuarioResponseDTO(UsuarioEntity usuario);

    UsuarioResponseDTO paraUsuarioResponseDTO(UsuarioRequestDTO usuario);

    List<UsuarioResponseDTO> paraListaUsuarioResponseDTO(List<UsuarioEntity> usuarios);

}
