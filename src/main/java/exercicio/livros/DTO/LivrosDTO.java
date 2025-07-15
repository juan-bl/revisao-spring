package exercicio.livros.DTO;

import exercicio.livros.Model.AutorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivrosDTO {
    private Long id;
    private String titulo;
    private String genero;
    private int paginas;
    private AutorModel autor;

}
