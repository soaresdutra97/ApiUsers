package com.example.cadastro_usuario.api.response;

//DADOS QUE VÃO PARA O CLIENTE COMO RESPOSTA DE UMA REQUISIÇÃO

public record UsuarioResponseDTO (
         Long id,
         String nome,
         String email,
         String documento,
         EnderecoResponseDTO endereco ){


}
