package biblioteca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import biblioteca.Model.Libro;
import biblioteca.Service.LibroService;

@Controller
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    private LibroService libroService;

    // Rotta per la homepage
    @GetMapping
    public String home() {
        return "index";
    }

    // Rotta per aggiungere un libro
    @GetMapping("/aggiungi")
    public String mostraFormularioAggiungi() {
        return "aggiungi-libro";
    }

    @PostMapping("/aggiungi")
    public String aggiungiLibro(@ModelAttribute Libro libro) {
        libroService.aggiungiLibro(libro);
        return "redirect:/biblioteca/libri"; // Redirect alla lista libri dopo l'aggiunta
    }

   
    @GetMapping("/libri")
    public String mostraListaLibri(Model model) {
        model.addAttribute("libri", libroService.getLibri());
        return "lista-libri"; // Ritorna la vista lista-libri.html
    }

    // Rotta per visualizzare i dettagli di un libro
    @GetMapping("/libri/{id}")
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
    @GetMapping("/libri/disponibilita/{id}")
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
