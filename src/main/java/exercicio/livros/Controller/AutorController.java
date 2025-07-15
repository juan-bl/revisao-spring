package exercicio.livros.Controller;

import exercicio.livros.DTO.AutoresDTO;
import exercicio.livros.Model.AutorModel;
import exercicio.livros.Service.AutorService;
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
    public List<AutorModel> listarAutor() {
        return autorService.listarLivros();
    }

    @GetMapping("/listar/{id}")
    public AutorModel listarPorId(@PathVariable Long id) {
        return autorService.listarPorId(id);
    }

    @PostMapping
    public AutoresDTO criarAutor(@RequestBody AutoresDTO novo) {
        return autorService.criarAutor(novo);
    }

    @PutMapping("/{id}")
    public AutoresDTO atualizarAutor(@PathVariable Long id, @RequestBody AutoresDTO novo) {
        return autorService.atualizarAutor(id, novo);
    }

    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Long id) {
        autorService.deletarAutor(id);
    }
}
