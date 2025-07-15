package exercicio.livros.DTO;

import exercicio.livros.Model.LivroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoresDTO {
    private Long id;
    private String nome;
    private List<LivroModel> livros;
}
