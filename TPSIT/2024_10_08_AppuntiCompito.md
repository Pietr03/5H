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
