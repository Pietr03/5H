<link rel="stylesheet" href="../style.css">

<!--
<label style="position:static;" for="tema-scuro">Tema scuro
<input type="checkbox" id="tema-scuro"></input>
</label>
-->

# 1. Definizione di API

## Cosa significa il termine API

API è l'acronimo di **"Application Programming Interface"**

## Scopo principale

Le API sono un insieme di regole, protocolli e strumenti che permettono la comunicazione tra diverse applicazioni tramite la rete.

Facilitano lo scambio di dati e funzionalità tra sistemi diversi, garantendo in maniera standardizzata.

---

# 2. Tipologie di API

## REST (Representational State Transfer)

- **Caratteristiche:**
  - basate sul **protocollo HTTP**,
  - **stateless**, quindi a parità di input si otterrà sempre lo stesso risultato finale, indipendentemente da ciò che si è fatto precedentemente con la stessa API,
  - **semplici** e **leggere**.
- **Metodi comuni:**
  - `GET`, i parametri sono passati in URL, serve per ottenere dati dal server
  - `POST`, i parametri sono passati nel corpo della richiesta _(il che la rende più sicura della GET)_, serve per inviare dati da caricare sul server
  - `PUT`, i parametri sono passati nel corpo della richiesta, serve per aggiornare dati sul server
  - `DELETE`, i parametri sono passati nell'URL
- **Formato dati:** Principalmente JSON (ma anche XML).

## SOAP (Simple Object Access Protocol)

- **Caratteristiche:** Protocollo standardizzato basato su XML, più formale e rigido.
- **Strumenti:** Richiede la definizione di un file WSDL (Web Services Description Language) per la descrizione dei servizi.

| Caratteristica  | SOAP                                             | REST                                        |
| --------------- | ------------------------------------------------ | ------------------------------------------- |
| Formato dati    | XML                                              | JSON, XML, ecc.                             |
| Protocollo      | Proprio, può usare vari trasporti                | Basato su HTTP                              |
| Sicurezza       | WS-Security, crittografia avanzata               | OAuth, HTTPS                                |
| Flessibilità    | Rigoroso e standardizzato                        | Più leggero e flessibile                    |
| Performance     | Più pesante e lento                              | Più veloce e scalabile                      |
| Utilizzo tipico | Sistemi aziendali, banking, transazioni critiche | API web, servizi cloud, applicazioni mobile |


## Differenze principali

| **Tipo di API** | **Pro**                                        | **Contro**                              |
| --------------- | ---------------------------------------------- | --------------------------------------- |
| **REST**        | Semplice, flessibile, basato su HTTP           | Dati fissi nelle risposte               |
| **SOAP**        | Maggiore sicurezza e standardizzazione         | Più complesso e pesante                 |


---

# 3. Funzionamento delle API

## Comunicazione tra Client e Server

1. **Client** invia una richiesta (request) all’API del server, specificando il tipo di azione (es. recupero dati, aggiornamento, cancellazione).
2. **Server** elabora la richiesta e restituisce una risposta (response) che contiene i dati richiesti o un messaggio di stato.

### Messaggi di stato
I codici di stato HTTP sono suddivisi in diverse categorie:
- **100-199**: Informativi – La richiesta è stata ricevuta e il processo continua.
- **200-299**: Successo – La richiesta è andata a buon fine.
- **300-399**: Reindirizzamento – Ulteriori azioni sono necessarie per completare la richiesta.
- **400-499**: Errore del client – La richiesta contiene errori o non può essere soddisfatta.
- **500-599**: Errore del server – Il server ha riscontrato un problema nell'elaborare la richiesta.

## Richieste e Risposte
- **Richiesta (Request)**: Include metodo (es. `GET`, `POST`), endpoint, parametri e/o dati nel corpo della richiesta.
- **Risposta (Response)**: Contiene lo status (`200 OK`, `404 Not Found`) e, se applicabile, i dati richiesti in formati standard (JSON, XML).

---
# 4. Esempi di API famose

## API di Google Maps
Consentono di integrare mappe, servizi di geolocalizzazione e indicazioni stradali in applicazioni web e mobile.

Ci sono diverse tipologie di API offerte da Goole in questo ambito:
- **Maps JavaScript API**:
  - Permette di incorporare mappe nei siti web
  - Supporta l'aggiunta di:
    - marker
    - livelli
- **Geodecoding API**:
  - Converte gli indirizzi in coordinate geografiche di latitudine e longitudine e viceversa
- **Places API**:
  - Fornisce informazioni su punti di interesse come ristoranti, parchi, musei, ecc...
- **Directions API**:
  - Calcola percorsi tra due o più punti
  - Supporta diverse varianti di percorsi adattandoli al veicolo scelto: auto, bici, trasporti pubblici, a piedi.
- **Distances Matrix API**:
  - Calcola la distanza e il tempo per viaggiare tra due punti della mappa
- **Street View API**:
  - Permette di visualizzare immagini a 360° di strade o luoghi.
- **Roads API**:
  - Fornisce informazioni sulle condizioni stradali, limiti di velocità e livello di traffico.


## API di ChatGPT
Le **API di ChatGPT** sono fornite da **OpenAI**, permettono di integrare l'AI nelle applicazioni, consentendo interazioni intelligenti basate sul linguaggio naturale.


### Principali API di ChatGPT  

#### 1. API di completamento (`/v1/completions`)  
- Utilizzata per completare testi o codici di cui si ha solo una parte e un contesto. 

#### 2. API di chat (`/v1/chat/completions`)  
- Pensata per conversazioni multi-turno, mantenendo il contesto.  
- Utilizza una lista di messaggi con ruoli (`system`, `user`, `assistant`).  


#### 3. API di embedding (`/v1/embeddings`)  
OpenAI restituisce un vettore di numeri che rappresenta il testo fornito nella richiesta. 
Questo vettore può essere confrontato con altri vettori per misurare la similarità tra testi.


#### 4. API di moderazione (`/v1/moderations`)  
Analizza un testo e rileva contenuti non conformi alle policy di OpenAI.  

#### 5. API per la generazione di immagini (`DALL·E API`)  
Dato un prompt testuale, restituisce un'immagine generata con AI, può anche modificare un'immagine già esistente.

#### 6. API per la sintesi vocale (`Text-to-Speech API`)  
Converte testi in voci, permette la scelta della lingua, il tono della voce e il genere.

#### 7. API per il riconoscimento vocale (`Whisper API`)  
Converte voci in testo.

# 5. Sicurezza e Accesso alle API

## API Key
È una chiave usata per l'autenticazione sul servizio in fase di richiesta.

## Access token
Funzionano in modo simile alle API, ma hanno una durata temporale limitata, quindi scadono dopo un certo tempo dalla loro generazione.

## Importanza della Sicurezza

- **Protezione:** avere un servizio che permette l'accesso tramite API, permette di regolare il traffico in modo più efficace, garantendo più sicurezza e stabilità al servizio.
- **Integrità e Riservatezza:** Garantisce che solo utenti e applicazioni autorizzate possano accedere e modificare i dati.
- **Controllo degli Accessi:** Permette di controllare il traffico generato dalle diverse API, così da permettere la disattivazione di queste in caso di comportamenti non in regola, o che superano le richieste previste dal piano scelto.



## Cosa sono i Web Service?

I Web Service sono applicazioni accessibili tramite rete (HTTP/HTTPS) che offrono dati e servizi agli applicativi con cui comunicano.

Utilizzano protocolli come SOAP o REST e sono impiegati per integrare sistemi distribuiti con tecnologie diverse.

## Differenza tra API e Web Service
API è un interfaccia basata su protocolli come l'HTTP e server per far comunicare due applicativi in modo semplice, usato nei sistemi centralizzati.

Un Web Service è un servizio che è situato in mezzo, tra il client e il server che implementa l'API, utile per sistemi distribuiti.