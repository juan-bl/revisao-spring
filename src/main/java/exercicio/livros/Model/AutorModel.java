package exercicio.livros.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "autor")
    private List<LivroModel> livro;
}
