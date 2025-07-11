package exercicio.livros.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Livro extends JpaRepository<exercicio.livros.Model.Livro, Long> {
}
