package exercicio.livros.Mapper;

import exercicio.livros.DTO.LivrosDTO;
import exercicio.livros.Model.LivroModel;
import org.springframework.stereotype.Component;

@Component
public class LivrosMapper {

    // Esse é o que vai receber os dados e enviar pro service. Controller -> DTO -> Mapper -> Service
    public LivroModel map(LivrosDTO livrosBody) {
        LivroModel livroModel = new LivroModel();
        livroModel.setId(livrosBody.getId());
        livroModel.setTitulo(livrosBody.getTitulo());
        livroModel.setGenero(livrosBody.getGenero());
        livroModel.setPaginas(livrosBody.getPaginas());
        livroModel.setAutor(livrosBody.getAutor());

        return livroModel;
    }

    // Esse é o que vai enviar uma resposta de volta pro usuario. Service -> DTO -> Mapper -> Controller
    public LivrosDTO map(LivroModel livroResposta) {
        LivrosDTO livrosDTO = new LivrosDTO();
        livrosDTO.setId(livroResposta.getId());
        livrosDTO.setTitulo(livroResposta.getTitulo());
        livrosDTO.setGenero(livroResposta.getGenero());
        livrosDTO.setPaginas(livroResposta.getPaginas());
        livrosDTO.setAutor(livroResposta.getAutor());

        return livrosDTO;
    }
}
