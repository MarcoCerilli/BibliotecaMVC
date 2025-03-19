# Biblioteca - Progetto Web (Java, Spring MVC)

Benvenuto nel progetto **Biblioteca**! Questo è un sistema di gestione di una biblioteca sviluppato utilizzando **Java**, **Spring Framework**, e altre tecnologie moderne. Il progetto segue l'architettura **MVC** (Model-View-Controller) per separare la logica di business, la gestione dei dati e la presentazione.

## Tecnologie utilizzate

### Linguaggi
- **Java** ![Java logo](https://upload.wikimedia.org/wikipedia/commons/1/1b/Java_logo_and_wordmark.svg)

### Frameworks
- **Spring Framework** (inclusi Spring MVC, Spring Boot) ![Spring logo](https://upload.wikimedia.org/wikipedia/commons/2/2c/Spring_Framework_Logo_2018.svg)
- **Thymeleaf** (Template Engine per la View)
  
### Database
- **MySQL** ![MySQL logo](https://upload.wikimedia.org/wikipedia/commons/6/69/MySQL_logo.svg)
- **JPA/Hibernate** (per l'interazione con il database)

### Strumenti
- **Maven** per la gestione delle dipendenze
- **Spring Boot** per avviare rapidamente l'applicazione
- **Git** per il versionamento del codice
- **GitHub** per l'hosting del repository

## Funzionalità

- **Gestione libri:** Aggiungi, visualizza, modifica e rimuovi libri dalla biblioteca.
- **Autenticazione utenti:** Sistema di login e gestione degli utenti.
- **Interfaccia utente:** Utilizzo di **Thymeleaf** per il rendering delle pagine HTML.
- **Database:** MySQL per salvare i dati relativi ai libri e agli utenti.
- **Modello MVC:** Separazione delle preoccupazioni tra la logica di business, la gestione dei dati e la visualizzazione.

## Struttura del progetto

Il progetto è strutturato secondo il pattern **MVC**:
- **Model:** Contiene la logica di business e le entità JPA (es. `Book`, `User`).
- **View:** Le pagine HTML sono gestite da **Thymeleaf** e servono per la visualizzazione.
- **Controller:** I controller gestiscono le richieste dell'utente, interagiscono con il modello e restituiscono le risposte alle viste.

## Installazione

1. **Clona il repository:**
   ```bash
   git clone https://github.com/MarcoCerilli/BibliotecaMVC.git



### Spiegazione dei punti principali:
1. **Linguaggi e Tecnologie:** Ho aggiunto **Java** come linguaggio principale e **Spring** (sia MVC che Spring Boot) come framework.
2. **Database:** Ho menzionato l'uso di **MySQL** per la gestione del database e **JPA/Hibernate** per l'interazione con il database.
3. **Funzionalità:** Ho incluso le caratteristiche principali del progetto come la gestione dei libri e l'autenticazione utenti.
4. **Struttura del progetto:** Ho descritto la separazione delle preoccupazioni tramite il pattern **MVC**.
5. **Installazione:** Ho dettagliato i passaggi per avviare il progetto in locale, compreso il setup del database e l'uso di Maven per compilarlo e avviarlo.

### Come aggiungere le immagini nel `README.md`:
Se vuoi includere le immagini dei loghi, puoi caricarle direttamente nel repository, in una cartella come `images/`, e usare l'URL relativo. Ecco come:

```markdown
![Spring logo](https://github.com/MarcoCerilli/BibliotecaMVC/blob/main/images/spring-logo.png)
