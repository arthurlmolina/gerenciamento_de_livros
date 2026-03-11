package com.example.gerenciamento_de_livros.repositories;

import com.example.gerenciamento_de_livros.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
