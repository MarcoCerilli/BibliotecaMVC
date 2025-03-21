// Funzione per inviare il messaggio
const sendMessage = () => {
    const messageInput = document.getElementById('message');
    const message = messageInput.value.trim();

    // Rimuovi il messaggio di errore precedente, se presente
    const existingError = document.querySelector('.error');
    if (existingError) existingError.remove();

    if (!message) {
        showError("Inserisci un messaggio valido.");
        return;
    }

    const username = localStorage.getItem('username') || 'UtenteAnonimo';

    const data = {
        message: message,
        username: username
    };

    // Seleziona il bottone di invio
    const sendButton = document.getElementById('sendButton'); // Usa un id specifico
    if (sendButton) {
        sendButton.disabled = true;
        sendButton.textContent = "Invio...";
    }

    fetch('/send', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) throw new Error(`Errore ${response.status}`);
        return response.json();
    })
    .then(data => {
        addMessageToChat(`[${new Date().toLocaleTimeString()}] ${data.username}: ${data.message}`, 'user');
        addMessageToChat(`Risposta automatica al tuo messaggio: "${data.message}". Ti ricontatteremo al più presto.`, 'bot');

        // Pulire il campo di input dopo l'invio
        messageInput.value = '';

        // Riabilita il pulsante dopo l'invio
        if (sendButton) {
            sendButton.disabled = false;
            sendButton.textContent = "Invia";
        }
    })
    .catch(error => {
        console.error('Errore:', error);
        showError("Si è verificato un errore, riprova.");
        if (sendButton) {
            sendButton.disabled = false;
            sendButton.textContent = "Invia";
        }
    });
};

// Funzione per aggiungere messaggi alla chat
const addMessageToChat = (text, type) => {
    const messagesContainer = document.getElementById('messages');
    if (!messagesContainer) return;

    const messageDiv = document.createElement('div');
    messageDiv.textContent = text;
    messageDiv.classList.add('chat-message', type);
    messageDiv.classList.add('fade-in'); // Aggiungi animazione

    messagesContainer.appendChild(messageDiv);
    messagesContainer.scrollTop = messagesContainer.scrollHeight;
};

// Funzione per mostrare errori
const showError = (message) => {
    const chatForm = document.getElementById('chatForm');
    if (!chatForm) return;

    const errorMessage = document.createElement('div');
    errorMessage.classList.add('error');
    errorMessage.textContent = message;
    chatForm.appendChild(errorMessage);

    setTimeout(() => errorMessage.remove(), 3000);
};

// -------------------------
// GESTIONE DEL POP-UP E CHAT
// -------------------------
document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById("infoModal");
    const span = document.querySelector(".close");
    const infoBtn = document.getElementById("infoBtn");
    const chatContainer = document.getElementById('chatContainer');

    if (infoBtn && modal) {
        infoBtn.onclick = function () {
            modal.style.display = "none"; // Chiudi il pop-up
            if (chatContainer) chatContainer.style.display = 'block';
        };
    }

    if (span && modal) {
        span.onclick = function () {
            modal.style.display = "none";
        };
    }

    window.onclick = function (event) {
        if (modal && event.target === modal) {
            modal.style.display = "none";
        }
    };
});
