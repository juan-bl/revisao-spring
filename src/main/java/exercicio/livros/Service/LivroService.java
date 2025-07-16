package exercicio.livros.Service;

import exercicio.livros.DTO.LivrosDTO;
import exercicio.livros.Mapper.LivrosMapper;
import exercicio.livros.Model.LivroModel;
import exercicio.livros.Repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;
    private LivrosMapper livrosMapper;

    public LivroService(LivroRepository livroRepository, LivrosMapper livrosMapper) {
        this.livroRepository = livroRepository;
        this.livrosMapper = livrosMapper;
    }

    public List<LivroModel> listarLivros() {
        return livroRepository.findAll();
    }

    public LivroModel listarPoId(Long id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        return livro.orElse(null);
    }

    public LivrosDTO criarLivro(LivrosDTO novoLivro) {
        LivroModel livro = livrosMapper.map(novoLivro);
        livro = livroRepository.save(livro);
        return livrosMapper.map(livro);
    }

    public LivrosDTO atualizarLivro(Long id, LivrosDTO livroAtualizado) {
        if (livroRepository.existsById(id)) {
            livroAtualizado.setId(id);
            LivroModel livro = livrosMapper.map(livroAtualizado);
            livro = livroRepository.save(livro);
            return livrosMapper.map(livro);
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
