package com.example.gerenciamento_de_livros.services;

import com.example.gerenciamento_de_livros.models.LivroModel;
import com.example.gerenciamento_de_livros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    //findAll
    public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }


    //post
    public LivroModel criarLivro(LivroModel livroModel){
        return livroRepository.save(livroModel);
    }

    //get
    public Optional<LivroModel> buscarId(Long id){
        return livroRepository.findById(id);
    }

    //update
    public LivroModel atualizar(Long id, LivroModel livroModel){
        LivroModel model = livroRepository.findById(id).get();
        model.setTitulo(livroModel.getTitulo());
        return livroRepository.save(model);
    }

    //delete
    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

}
