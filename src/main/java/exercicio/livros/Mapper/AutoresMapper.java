package exercicio.livros.Mapper;

import exercicio.livros.DTO.AutoresDTO;
import exercicio.livros.Model.AutorModel;
import org.springframework.stereotype.Component;

@Component
public class AutoresMapper {

    // Esse é o que vai receber os dados e enviar pro service. Controller -> DTO -> Mapper -> Service
    public AutorModel map(AutoresDTO autoresBody) {
        AutorModel autorModel = new AutorModel();
        autorModel.setId(autoresBody.getId());
        autorModel.setNome(autoresBody.getNome());
        autorModel.setLivros(autoresBody.getLivros());

        return autorModel;
    }

    // Esse é o que vai enviar uma resposta de volta pro usuario. Service -> DTO -> Mapper -> Controller
    public AutoresDTO map(AutorModel autoresResposta) {
        AutoresDTO autoresDTO = new AutoresDTO();
        autoresDTO.setId(autoresResposta.getId());
        autoresDTO.setNome(autoresResposta.getNome());
        autoresDTO.setLivros(autoresResposta.getLivros());

        return autoresDTO;
    }
}
