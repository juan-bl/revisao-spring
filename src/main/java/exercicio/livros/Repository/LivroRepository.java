package exercicio.livros.Repository;

import exercicio.livros.Model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
