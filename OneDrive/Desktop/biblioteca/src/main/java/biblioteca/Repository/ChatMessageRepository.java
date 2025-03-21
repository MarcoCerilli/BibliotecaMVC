package biblioteca.Repository;

import biblioteca.Model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    // Puoi aggiungere query personalizzate se necessario
}
