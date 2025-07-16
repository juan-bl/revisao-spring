package exercicio.livros.Controller;

import exercicio.livros.DTO.AutoresDTO;
import exercicio.livros.Model.AutorModel;
import exercicio.livros.Service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autor")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar autores", description = "Rota que lista todos os autores cadastrados")
    public List<AutorModel> listarAutor() {
        return autorService.listarLivros();
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar autores por ID", description = "Rota que lista todos os autores cadastrados por ID")
    public AutorModel listarPorId(@Parameter(description = "Extrai o ID da URL") @PathVariable Long id) {
        return autorService.listarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar autor", description = "Rota para o cadastro de autores")
    public AutoresDTO criarAutor(@io.swagger.v3.oas.annotations.parameters.RequestBody @Parameter(description = "Extrai as informações do novo usuario do body") @RequestBody AutoresDTO novo) {
        return autorService.criarAutor(novo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar autor", description = "Rota para atualizar um autor")
    public AutoresDTO atualizarAutor(@Parameter(description = "Extrai o ID da URL") @PathVariable Long id, @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Extrai as informações para a atualização usuario do body") @RequestBody AutoresDTO novo) {
        return autorService.atualizarAutor(id, novo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar autor", description = "Rota para deletar um autor")
    public void deletarAutor(@Parameter(description = "Extrai o ID da URL") @PathVariable Long id) {
        autorService.deletarAutor(id);
    }
}
