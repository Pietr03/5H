<link rel="stylesheet" href="../style.css">

# HTTP (Hypertext Transfer Protocol)

L'**HTTP** è un protocollo di trasferimento ipertestuale che opera a livello applicativo. È il "linguaggio" utilizzato da browser e server per scambiarsi informazioni.

## Origini del WWW

Il **World Wide Web (WWW)** è nato dall'insieme di diverse tipologie di risorse. Le principali sono:
- **HTML** (HyperText Markup Language)
- **URL** (Uniform Resource Locator)
- **HTTP** (Hypertext Transfer Protocol)

## Trasmissione delle risorse

L'HTTP viene utilizzato per trasmettere risorse, non solo file. Alcuni termini importanti da conoscere sono:

### W3C (World Wide Web Consortium)

Un'organizzazione che sviluppa standard per il web.

### URI (Uniform Resource Identifier)

Un identificatore generico per una risorsa su una rete. Può essere un nome o un indirizzo completo. Le categorie principali di URI includono:

- **URN (Uniform Resource Name)**: identifica una risorsa attraverso un nome univoco, ad esempio: *urn:isbn:978-3-16-148410-0* (il codice di un libro, senza informazioni sul dove trovarlo).
  
- **URL (Uniform Resource Locator)**: è un identificatore per un indirizzo preciso, che include il protocollo (es. *http://*, *https://*) e l'indirizzo della risorsa (es. *www.google.com*).

## Versioni di HTTP

Le principali versioni dell'HTTP sono:
- **HTTP/1.0** (1996)
- **HTTP/1.1** (1997, aggiornato nel 1999)
- **HTTP/2.0** (2015)

La versione **1.1** permette di specificare una **connessione permanente** e consente il criptaggio di alcuni dati. Con **connessione permanente** si intende che una richiesta e la risposta avvengono all'interno della stessa connessione, grazie al server che mantiene aperta la connessione TCP dopo aver inviato la risposta.

# HTTP e il modello Client/Server

La versione **2.0** introduce diverse funzionalità innovative:

### 1. Multiplexing
- **HTTP/2** consente l'invio simultaneo di molteplici richieste e risposte su una singola connessione TCP.

### 2. Compressione degli Header
- Gli header ridondanti vengono compressi, riducendo il carico sulla rete e migliorando le prestazioni.

### 3. Server Push
- Il server può inviare proattivamente al client risorse previste per l'uso (ad esempio, file CSS, immagini, JavaScript) senza che il client le richieda esplicitamente.

![Anatomia di un URL](./immagini/1_url_anatomy.png)

# Il protocollo HTTP
Il protocollo HTTP per comunicare utilizza le sessioni, che funzionano secondo il seguente ordine:
1. **Il client**
    1. Inizia stabilendo una connessione TCP con il server
    2. sceglie la porta tramite cui comunicare *(la porta ":80" viene usata di default)*
    3. effettua una richiesta *(request)* in formato HTTP come testo contenente un URL
2. **Il server**:
    1. produce il file di risposta e lo invia *(response)*
    2. chiude la connessione TCP


![Comunicazione HTTP client-server](./immagini/client-server_https.png)

---

# Tipi di connessione
Esistono due tipi di connesione permanente:
- ### Connessione permanente **incanalata**
    - **Invia tutte le risposte subito** seguendo una coda chiamata **pipeline**, che segue lo stesso ordine delle domande ricevute
- ### Connessione permanente **non incanalata**
    - **Aspetta la conferma della ricezione di una risposta** prima di inviare la risposta successiva.


## Prima riga
Contiene la versione HTTP usata dal client oppure lo status code della response nel caso del server

chiave : valore

header: 
- user agent (indica versione browser del client)
- host
- mime


CRLF (Carriage Return Line Feed)
Carriage return, "a capo"
line feed, "nuova riga"

metodo: get, post, put , delete

ESEMPIO richiesta HTTP: GET /percorso/file.html HTTP/1.1


Corpo e header sono facoltativi


