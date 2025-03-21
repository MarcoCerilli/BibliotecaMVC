package biblioteca.Controller;

import biblioteca.Model.ChatMessage;
import biblioteca.Repository.ChatMessageRepository;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @PostMapping("/send")
    public ResponseEntity<ChatMessage> sendMessage(@RequestBody ChatMessage chatMessage) {
        // Imposta la data e ora attuali
        chatMessage.setTimestamp(LocalDateTime.now());

        // Imposta lo stato del messaggio su 'inviato'
        chatMessage.setStatus(ChatMessage.Status.INVIATO);

        // Puoi impostare il nome dell'utente, se disponibile, oppure lasciare il campo vuoto
        chatMessage.setUsername("Utente");

        // Salva il messaggio nel database
        chatMessageRepository.save(chatMessage);

        // Restituisce il messaggio appena inviato come risposta JSON
        return ResponseEntity.ok(chatMessage);
    }
}
