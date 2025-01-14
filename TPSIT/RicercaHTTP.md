<link rel="stylesheet" href="../style.css">

<label for="tema">Tema scuro</label>
<input type="checkbox" id="tema-scuro"></input>

# HEADERS RESPONSE HTTP

Questi header sono fondamentali per il funzionamento del protocollo HTTP, poiché consentono la gestione ottimale delle risorse e la comunicazione efficace tra client e server.
I principali sono:

-   Date
-   Content Type
-   Transfer-Encoding
-   Connection
-   Age
-   Last Modified
-   Server
-   Content-Encoding

### Date

Contiene il timestamp, ovvero la data e l'ora del server, in cui è stata generata la risposta, solitamente nel formato GMT.

**Esempio:**

```http
Date: Wed, 26 Sep 2024 14:28:00 GMT
```

---

### Content-Type

Indica il tipo di contenuto del corpo del messaggio HTTP, utilizzando i tipi MIME (Multipurpose Internet Mail Extensions). Indica al client come interpretare i dati ricevuti.

**Esempio:**

```http
Content-Type: text/html; charset=UTF-8
```

---

### Transfer-Encoding

Indica il modo in cui i dati sono stati trasferiti dal server al client.

**Esempio:**

```http
Transfer-Encoding: chunked
```

_Chunked permette di inviare i dati in blocchi di dimensione variabile_

---

### Connection

Specifica il comportamento della connessione TCP tra client e server. Può indicare se la connessione deve essere chiusa subito dopo la risposta o mantenuta aperta per future richieste.

**Esempio:**

```http
Connection: keep-alive
```

---

### Age

Indica quanto tempo è passato da quando la risposta è stata memorizzata nella cache del server o del proxy. Questo header è utile per capire quanto "vecchia" è una risposta servita da una cache intermedia.

**Esempio:**

```http
Age: 3600
```

---

### Last-Modified

Indica la data e l'ora in cui la risorsa indicata dall'URL è stata modificata per l'ultima volta. Aiuta a capire quanto il dato possa essere aggiornato.

**Esempio:**

```http
Last-Modified: Tue, 25 Sep 2024 10:12:00 GMT
```

---

### Server

Indica la versione e il tipo del server che ha gestito la richiesta HTTP.

**Esempio:**

```http
Server: Apache/2.4.29 (Ubuntu)
```

---

### Content-Encoding

Indica quale algoritmo di compressione è stato usato per comprimere il corpo della risposta. Il client dovrà decomprimere il contenuto, con un algoritmo analogo, prima di utilizzarlo.
La compressione dei dati aiuta a limitare l'uso della banda di rete.

**Esempio:**

```http
Content-Encoding: gzip
```
