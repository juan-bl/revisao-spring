package exercicio.livros.Repository;

import exercicio.livros.Model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {
}
