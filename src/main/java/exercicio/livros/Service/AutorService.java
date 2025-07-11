package exercicio.livros.Service;

import exercicio.livros.Model.AutorModel;
import exercicio.livros.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    //R
    public List<AutorModel> listarLivros() {
        return autorRepository.findAll();
    }

    //R
    public AutorModel listarPorId(Long id) {
        Optional<AutorModel> autorPorId = autorRepository.findById(id);
        return autorPorId.orElse(null);
    }

    //C
    public AutorModel criarAutor(AutorModel novoAutorModel) {
        return autorRepository.save(novoAutorModel);
    }

    //U
    public AutorModel atualizarAutor(Long id, AutorModel autorModelAtualizado) {
        if (autorRepository.existsById(id)) {
            autorModelAtualizado.setId(id);
            return autorRepository.save(autorModelAtualizado);
        }
        return null;
    }

    //D
    public String deletarAutor(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return "Usuario do id " + id + " deletado com sucesso";
        } else {
            return "Autor não encontrado.";
        }
    }
}
