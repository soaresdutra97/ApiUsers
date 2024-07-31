package com.example.cadastro_usuario.api.converter;

import com.example.cadastro_usuario.api.request.EnderecoRequestDTO;
import com.example.cadastro_usuario.api.request.UsuarioRequestDTO;
import com.example.cadastro_usuario.api.response.EnderecoResponseDTO;
import com.example.cadastro_usuario.api.response.UsuarioResponseDTO;
import com.example.cadastro_usuario.infrastructure.entities.EnderecoEntity;
import com.example.cadastro_usuario.infrastructure.entities.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioConverter {

    public UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO usuarioDTO){
        return UsuarioEntity.builder()
                .nome(usuarioDTO.getNome())
                .documento(usuarioDTO.getDocumento())
                .email(usuarioDTO.getEmail())
                .endereco(paraEnderecoEntity(usuarioDTO.getEndereco()))
                .build();
    }

    private EnderecoEntity paraEnderecoEntity(EnderecoRequestDTO enderecoDTO){
        return EnderecoEntity.builder()
                .cep(enderecoDTO.getCep())
                .rua(enderecoDTO.getRua())
                .bairro(enderecoDTO.getBairro())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .numero(enderecoDTO.getNumero())
                .build();
    }


    public UsuarioResponseDTO paraUsuarioResponseDto(UsuarioEntity entity){
        return UsuarioResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .documento(entity.getDocumento())
                .email(entity.getEmail())
                .endereco(paraEnderecoResponseDto(entity.getEndereco()))
                .build();
    }

    private EnderecoResponseDTO paraEnderecoResponseDto(EnderecoEntity entity){
        return EnderecoResponseDTO.builder()
                .cep(entity.getCep())
                .rua(entity.getRua())
                .bairro(entity.getBairro())
                .cidade(entity.getCidade())
                .complemento(entity.getComplemento())
                .numero(entity.getNumero())
                .build();
    }

    public List<UsuarioResponseDTO> paraUsuarioResponseDtoList(List<UsuarioEntity> entity){
        return entity.stream().map(this::paraUsuarioResponseDto).toList();
    }
}