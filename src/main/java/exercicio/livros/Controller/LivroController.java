package exercicio.livros.Controller;

import exercicio.livros.DTO.LivrosDTO;
import exercicio.livros.Model.LivroModel;
import exercicio.livros.Service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livro")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    //fazer o ocntroller

    @GetMapping("/listar")
    public List<LivroModel> listarLivros() {
        return livroService.listarLivros();
    }

    @GetMapping("/listar/{id}")
    public LivroModel listarPorId(@PathVariable Long id) {
        return livroService.listarPoId(id);
    }

    @PostMapping("/criar")
    public LivrosDTO criarLivro(@RequestBody LivrosDTO livroNovo) {
        return livroService.criarLivro(livroNovo);
    }

    @PutMapping("/atualizar/{id}")
    public LivrosDTO atualizarLivro(@PathVariable Long id, @RequestBody LivrosDTO livroAtualizado) {
        return livroService.atualizarLivro(id, livroAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return "Livro do id " + id + "deletado com sucesso";
    }
}

