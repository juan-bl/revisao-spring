package exercicio.livros.Controller;

import exercicio.livros.DTO.LivrosDTO;
import exercicio.livros.Model.LivroModel;
import exercicio.livros.Service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @Operation(summary = "Listar livros", description = "Rota que lista todos os livros cadastrados")
    public List<LivroModel> listarLivros() {
        return livroService.listarLivros();
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar livros por ID", description = "Rota que lista todos os livros cadastrados por ID")
    public LivroModel listarPorId(@Parameter(description = "Extrai o ID da URL") @PathVariable Long id) {
        return livroService.listarPoId(id);
    }

    @PostMapping("/criar")
    @Operation(summary = "Cadastrar livro", description = "Rota para o cadastro de livro")
    public LivrosDTO criarLivro(@io.swagger.v3.oas.annotations.parameters.RequestBody @Parameter(description = "Extrai as informações do novo usuario do body") @RequestBody LivrosDTO livroNovo) {
        return livroService.criarLivro(livroNovo);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar livro", description = "Rota para atualizar um livro")
    public LivrosDTO atualizarLivro(@Parameter(description = "Extrai o ID da URL") @PathVariable Long id, @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Extrai as informações para a atualização usuario do body") @RequestBody LivrosDTO livroAtualizado) {
        return livroService.atualizarLivro(id, livroAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar livro", description = "Rota para deletar um livro")
    public String deletarLivro(@Parameter(description = "Extrai o ID da URL") @PathVariable Long id) {
        livroService.deletarLivro(id);
        return "Livro do id " + id + "deletado com sucesso";
    }
}

