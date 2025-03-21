package biblioteca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import biblioteca.Model.Libro;
import biblioteca.Service.LibroService;

@Controller
public class BibliotecaController {

    @Autowired
    private LibroService libroService;

    // Home page accessibile da "/"
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Rotta per aggiungere un libro
    @GetMapping("/biblioteca/aggiungi")
    public String mostraFormularioAggiungi() {
        return "aggiungi-libro";
    }

    @PostMapping("/biblioteca/aggiungi")
    public String aggiungiLibro(@ModelAttribute Libro libro) {
        libroService.aggiungiLibro(libro);
        return "redirect:/biblioteca/libri";
    }

    // Rotta per la lista dei libri
    @GetMapping("/biblioteca/libri")
    public String mostraListaLibri(Model model) {
        model.addAttribute("libri", libroService.getLibri());
        return "lista-libri";
    }

    // Rotta per i dettagli di un libro
    @GetMapping("/biblioteca/libri/{id}")
    public String mostraDettagliLibro(@PathVariable Long id, Model model) {
        Libro libro = libroService.getLibroById(id);
        if (libro != null) {
            model.addAttribute("libro", libro);
            return "dettagli-libro";
        }

        model.addAttribute("errore", "Libro non trovato");
        return "errore";
    }

    // Rotta per la disponibilità di un libro
    @GetMapping("/biblioteca/libri/disponibilita/{id}")
    public String disponibilitaLibro(@PathVariable Long id, Model model) {
        Libro libro = libroService.getLibroById(id);
        if (libro != null) {
            model.addAttribute("libro", libro);
            return "disponibilita-libro";
        }

        model.addAttribute("errore", "Libro non trovato");
        return "errore";
    }
}
