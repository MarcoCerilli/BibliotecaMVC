# Biblioteca - Progetto Web (Java, Spring MVC)

Benvenuto nel progetto **Biblioteca**! Questo è un sistema di gestione di una biblioteca sviluppato utilizzando **Java**, **Spring Framework**, e altre tecnologie moderne. Il progetto segue l'architettura **MVC** (Model-View-Controller) per separare la logica di business, la gestione dei dati e la presentazione.

## Tecnologie utilizzate

### Linguaggi
- **Java** 
![image](https://github.com/user-attachments/assets/4831a740-9aef-4411-b81e-5c2ea912f9aa)

### Frameworks
- **Spring Framework** (inclusi Spring MVC, Spring Boot)
-  ![image](https://github.com/user-attachments/assets/f97fd1b7-fead-46fa-a197-0d2bc4b44e5a)

- **Thymeleaf** (Template Engine per la View)
- ![image](https://github.com/user-attachments/assets/4cd62c05-e3b4-4b14-8d1b-5801275ce21f)

  
### Database
- **MySQL** ![image](https://github.com/user-attachments/assets/3a364ed5-7a05-4a2e-b3e0-b844dcbcdf37)

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
