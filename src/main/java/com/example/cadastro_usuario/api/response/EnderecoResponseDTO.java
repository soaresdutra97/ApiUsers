package com.example.cadastro_usuario.api.response;

import lombok.*;


public record EnderecoResponseDTO (String rua,
     Long numero,
     String bairro,
     String complemento,
     String cidade,
     String cep) {

}
