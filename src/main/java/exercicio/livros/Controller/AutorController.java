package exercicio.livros.Controller;

import exercicio.livros.Service.AutorServ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("autor")
public class Autor {

    private AutorServ autorServ;

    public Autor(AutorServ autorServ) {
        this.autorServ = autorServ;
    }

    @GetMapping("/listar")
    public List<exercicio.livros.Model.Autor> listarAutor() {
        return autorServ.listarLivros();
    }
}
