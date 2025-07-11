package exercicio.livros.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Autor extends JpaRepository<exercicio.livros.Model.Autor, Long> {
}
