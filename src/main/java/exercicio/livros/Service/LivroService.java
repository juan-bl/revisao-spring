package exercicio.livros.Service;

import exercicio.livros.Model.LivroModel;
import exercicio.livros.Repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<LivroModel> listarLivros() {
        return livroRepository.findAll();
    }

    public LivroModel listarPoId(Long id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        return livro.orElse(null);
    }

    public LivroModel criarLivro(LivroModel novoLivro) {
        return livroRepository.save(novoLivro);
    }

    public LivroModel atualizarLivro(Long id, LivroModel livroAtualizado) {
        if (livroRepository.existsById(id)) {
            livroAtualizado.setId(id);
            return livroRepository.save(livroAtualizado);
        }
        return null;
    }

    public String deletarLivro(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return "Usuario do id " + id + " deletado com sucesso";
        } else {
            return "Autor não encontrado.";
        }
    }
}
