package com.example.cadastro_usuario.infrastructure.repository;

import com.example.cadastro_usuario.infrastructure.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
}
