package biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.Model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}