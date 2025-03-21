package biblioteca.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import biblioteca.Model.User;
import biblioteca.Service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Mostra la pagina di login
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";  // Ritorna la vista di login
    }

    // Mostra la pagina di registrazione
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";  // Ritorna la vista di registrazione
    }

    // Gestisce la registrazione dell'utente
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.existsByUsername(username)) {
            model.addAttribute("error", "Username già preso!");  // Errore se lo username è già in uso
            return "register";  // Ritorna la vista di registrazione
        }

        User user = new User(username, passwordEncoder.encode(password));  // Cripta la password
        userService.save(user);  // Salva l'utente
        return "redirect:/login";  // Reindirizza alla pagina di login
    }

    // Gestisce il login dell'utente
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        // Crea il token di autenticazione
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        // Tenta di autenticare
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // Se l'autenticazione ha successo, imposta il contesto di sicurezza
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/";  // Reindirizza alla home page
    }
}
