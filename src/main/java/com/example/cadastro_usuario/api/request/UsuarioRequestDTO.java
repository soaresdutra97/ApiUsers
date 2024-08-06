package com.example.cadastro_usuario.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//DADOS QUE VEM DO CLIENTE
public class UsuarioRequestDTO {

    private String nome;
    @JsonProperty(required = true)
    private String email;
    private String documento;
    private EnderecoRequestDTO endereco;
}
