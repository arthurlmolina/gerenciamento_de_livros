package controllers;


import com.example.gerenciamento_de_livros.models.LivroModel;
import com.example.gerenciamento_de_livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")
public class livroController {

    @Autowired
    private LivroService livroService;

    @GetMapping //findAll();
    public ResponseEntity<List<LivroModel>> findAll(){
        List<LivroModel> request = livroService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livroModel){
        LivroModel request = livroService.criarLivro(livroModel);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequestUri().
                path("/{id}").
                buildAndExpand(livroModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<LivroModel> buscarId(@PathVariable Long id){
        return livroService.buscarId(id);
    }

    @PutMapping("/{id}")
    public LivroModel atualizar(@PathVariable Long id, @RequestBody LivroModel livroModel){
        return livroService.atualizar(id,livroModel);
    }

}
