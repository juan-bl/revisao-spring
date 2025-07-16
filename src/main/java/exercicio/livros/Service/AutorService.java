package exercicio.livros.Service;

import exercicio.livros.DTO.AutoresDTO;
import exercicio.livros.Mapper.AutoresMapper;
import exercicio.livros.Model.AutorModel;
import exercicio.livros.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private AutorRepository autorRepository;
    private AutoresMapper autoresMapper;

    public AutorService(AutorRepository autorRepository, AutoresMapper autoresMapper) {
        this.autorRepository = autorRepository;
        this.autoresMapper = autoresMapper;
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
    public AutoresDTO criarAutor(AutoresDTO novoAutorModel) {
        AutorModel autor = autoresMapper.map(novoAutorModel);
        autor = autorRepository.save(autor);
        return autoresMapper.map(autor);
    }

    //U
    public AutoresDTO atualizarAutor(Long id, AutoresDTO autorModelAtualizado) {
        if (autorRepository.existsById(id)) {
            autorModelAtualizado.setId(id);
            AutorModel autor = autoresMapper.map(autorModelAtualizado);
            autor = autorRepository.save(autor);
            return autoresMapper.map(autor);
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
