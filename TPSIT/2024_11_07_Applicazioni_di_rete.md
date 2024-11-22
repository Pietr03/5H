<link rel="stylesheet" href="../style.css">

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
