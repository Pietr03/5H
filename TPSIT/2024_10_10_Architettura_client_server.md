<link rel="stylesheet" href="../style.css">

# Tecnologie del web
Possiamo distinguere le tecnologie del We in **due gruppi**, in base al posto in cui avvengono le eleaborazioni.

- Possiamo schematire la comunicazione client-server in tre fasi dell'elaborazione
    - Invio Request
    - Elaborazione della response
    - Invio Response

![Comunicazione HTTP client-server](./immagini/client-server_https.png)

<div class="identation">

## 1. Tecnologie client side
Sono strutture tecnologiche in cui l'elaborazione avviene sul cliente, tipicamente nel browser.
- le paggine che usano soltanto tecnologie client side possono funzionare senza un web server, aprendo la pagina sul proprio browser con il path sul file system
- se la pagina web non necessita di elaborazione lato server, allora il codice sorgente della pagina sarà in chiaro per l'utente
- le parti di codice che utilizzano tecnologie client side sono fisibili e i linguaggi utilizzati sono html e javascript

## 2. Tecnologie server side
Sono strutture tecnologiche in cui l'elaborazione avviene sul server, tipicamente nel web server.

Esempi di tecnologie server side: PHP e Java servlet.

Elaborano il codice della pagina e la restituiscono agli utenti che la richiedono tramite un URL.

</div>

---

# Modello client-server
È costituito da **host**, che gestiscono le risorse:
- **client**, che richiedono le risorse
- **server**, che elaborano le risorse

Non sono gli host ad essere server o client, ma i processi che sono in esecuzione su di essi.

Per processo di intende un programma in esecuzione, su un host possono essere eseguiti diversi processi, che gestiscono le risorse.

**Un host può essere contemporaneamente sia server che client.**

---

- Programma chiamato client richiede servizi ad un altro programma chiamato server
- Quest'ultimo è ospitato su un computer chiamato host, che ascolta le richeste tramite un socket su una determinata porta, in attesa di richieste future dai client
- il client invia la richiesta al server tentando la connessione sopra la porta associata al socket del server