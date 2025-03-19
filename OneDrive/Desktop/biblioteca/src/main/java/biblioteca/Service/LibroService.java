package biblioteca.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.Model.Libro;
import biblioteca.Repository.LibroRepository;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro aggiungiLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Libro> getLibri() {
        return libroRepository.findAll();
    }

     public Libro getLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }
}
