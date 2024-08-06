package com.example.cadastro_usuario.Business;

import com.example.cadastro_usuario.api.converter.UsuarioConverter;
import com.example.cadastro_usuario.api.converter.UsuarioMapper;
import com.example.cadastro_usuario.api.converter.UsuarioUpdateMapper;
import com.example.cadastro_usuario.api.request.UsuarioRequestDTO;
import com.example.cadastro_usuario.api.response.UsuarioResponseDTO;
import com.example.cadastro_usuario.infrastructure.entities.UsuarioEntity;
import com.example.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioUpdateMapper usuarioUpdateMapper;

    public UsuarioEntity salvaUsuario(UsuarioEntity usuarioEntity){
        return usuarioRepository.saveAndFlush(usuarioEntity);
    }

    public UsuarioResponseDTO gravaUsuarios(UsuarioRequestDTO usuarioRequestDTO){
        try{
            notNull(usuarioRequestDTO, "Os dados do usuário são obrigatórios");
            UsuarioEntity usuarioEntity = salvaUsuario(usuarioConverter.paraUsuarioEntity(usuarioRequestDTO));
            return usuarioMapper.paraUsuarioResponseDTO(usuarioEntity);
        } catch (Exception e){
            throw new RuntimeException("Erro ao gravar dados de usuário"); //CRIAR BUSINESS EXCEPTION
        }
    }

    public UsuarioResponseDTO atualizaCadastro(UsuarioRequestDTO usuarioRequestDTO, String id){
        try {
            notNull(usuarioRequestDTO, "Os dados do usuário são obrigatórios");
            UsuarioEntity usuario = usuarioRepository.findById(Long.valueOf(id)).orElseThrow(()-> new RuntimeException("Não foi encontrado"));
            usuarioUpdateMapper.updateUsuarioFromDTO(usuarioRequestDTO, usuario);
            return usuarioMapper.paraUsuarioResponseDTO(salvaUsuario(usuario));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gravar dados de usuário");
        }
    }

    public UsuarioResponseDTO buscaDadosUsuario(String email){
        return usuarioMapper.paraUsuarioResponseDTO(usuarioRepository.findByEmail(email));
    }

    public void deletaDadosUsuario(String email){
        usuarioRepository.deleteByEmail(email);
    }

    public List<UsuarioResponseDTO> buscaTodosUsuarios(){
        return usuarioMapper.paraListaUsuarioResponseDTO(usuarioRepository.findAll());
    }

}