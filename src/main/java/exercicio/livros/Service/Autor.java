package exercicio.livros.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Autor {

    private exercicio.livros.Repository.Autor autorRepo;

    public Autor(exercicio.livros.Repository.Autor autorRepo) {
        this.autorRepo = autorRepo;
    }

    //R
    public List<exercicio.livros.Model.Autor> listarLivros() {
        return autorRepo.findAll();
    }

    //R
    public exercicio.livros.Model.Autor listarPorId(Long id) {
        Optional<exercicio.livros.Model.Autor> autorPorId = autorRepo.findById(id);
        return autorPorId.orElse(null);
    }

    //C
    public exercicio.livros.Model.Autor criarAutor(exercicio.livros.Model.Autor autor) {
        return autorRepo.save(autor);
    }

    //U
    public String atualizarAutor(exercicio.livros.Model.Autor autor, Long id) {
        if (autorRepo.existsById(id)) {
            autor.setId(id);
            autorRepo.save(autor);
            return "Autor atualizado com sucesso!";
        } else {
            return "Autor não encontrado.";
        }
    }

    //D
    public String deletarAutor(Long id) {
        if (autorRepo.existsById(id)) {
            autorRepo.deleteById(id);
            return "Usuario do id " + id + " deletado com sucesso";
        } else {
            return "Autor não encontrado.";
        }
    }
}
