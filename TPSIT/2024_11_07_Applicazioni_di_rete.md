<link rel="stylesheet" href="../style.css">

<label style="" for="tema-scuro">Tema scuro
    <input type="checkbox" id="tema-scuro"></input>
</label>

# Il modello ISO/OSI e le applicazioni

Nel modello ISO/OSI e TCP il livello delle applicazioni si occupa di implementare le applicazioni di rete che vengono utilizzate dall'utente finale.

Il programmatore non si deve preoccupare dei livelli inferiori ma soltanto utilizzare le primitive di comunicazione.

# Rete

Una rete è un'interfaccia di rete per la comunicazione tra computer.

Il modello ISO/OSI ha un livello per rappresentare la rete e ha un livello per rappresentare le applicazioni di rete.

# ISO/OSI

ISO/OSI ha un livello per rappresentare la rete e ha un livello per rappresentare le applicazioni di rete.

---

# Applicazione di rete

## Concentrata

Applicazione che si affida ad un unico server (o host)

## Distribuita

Applizazione di rete, che si basa su più server (o nodi)

---

# Identificazione mediante socket

I processi sono identificati da un indirizzo ip (comuni per i processi presenti su uno stesso host o nodo) e una porta (associata ad un **socket** in ascolto):

-   Identificatore del nodo su cui opera il processo
-   identificatore del processo all'interno del nodo

Un socket consente di comunicare attraverso la rete utilizzando la pila **TCP/IP** ed è quindi parte integrante del protocollo
TCP/IP

Le API (Application Programming Interface) possi essere definite come un insieme di regole, strumenti e protocolli che permettono ai diversi software di comunicare tra loro. Le API offrono un'interfaccia che consente un programma di accedere ai dati o alle funzionalità di un altro programma, servizio o sistema senza conoscere i dettagli interni del suo funzionamento.

---

## Socket di benvenuto (Listening socket)

È il socket utilizzato da un server per ascoltare le richieste di connessione in arrivo dai client.

Funziona in modalità passiva, ovvero non scambia dati direttamente, ma si limita ad attendere connessioni.

Viene creato e configurato tramite le seguenti operazioni principali:

-   **Creazione del socket**: chiamata alla funzione **socket()**.
-   **Binding**: associazione del socket a un indirizzo IP e una porta tramite la funzione **bind()**.
-   **Ascolto**: il socket è messo in ascolto di connessioni con la funzione **listen()**.

---

## Socket di connessione (Connected socket)

È il socket creato per gestire una connessione specifica tra il server e un client. Quando una richiesta di connesione è accettata (tramite la funzione **accept()**), il server genera un nuovo socket dedicato a quella connessione. Questo socket viene utilizzato per:

-   ricevere dati dal client
-   inviare dati al client

---

## Relazione tra i due socket

Il socket di connessione è indipendente dal socket di benvenuto.

Ciò consente al server di continuare ad ascoltare nuove richieste di connessione con il socket di benvenuto, mentre gestisce le comunicazioni con i client già connessi tramite i socket di connessione.

Il **socket di benvenuto** rimane sempre attivo per ricevere nuove richieste. Oni volta che una connessione viene stabilita, un **socket di connessione** viene creato per gestire quella specifica connessione.

---

## Schema di funzionamento

1. Il server apre un socket di benvenuto.
2. Il client invia una richiesta di connessione al server.
3. Il server accetta la richiesta di connessione e genera un socket di connessione per gestirla.
4. Il socket di benvenuto si libera e ritorna ad ascoltare prossime connessionig.

---
