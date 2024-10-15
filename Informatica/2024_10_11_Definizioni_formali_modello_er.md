Tabella = schema relazione (insieme di tuple)

DB = schema relazionale (insieme di tabelle o schemi relazione)

---
# Def 1: Schema relazione
## R:{T} (Tabella, insieme di tuple)
Lo schema relaziona + una coppia formata da un nome di relazione R e da un "tipo di relazione" definito così:

- sono tipi primitivi (interi, reali, booleani e stringhe)
- se T1, ..., Tn sono tipi primitivi a A1, ..., An sono etichette => (A1:T1, ..., An:Tn)  è un tipo ennupla di grado n
- se T è un tipo Ennupla, => {T} è un tipo di insieme ennuple

ennupla: è una tupla con n elementi al suo interno


Es:
```
- T1 : int              - A1 : id
- T2 : string           - A2 : nome
- T3 : string           - A3 : cognome

```

---
# Def 2: Schema relazionale
## Ri:{Ti}; i = 1, ..., k   (DB, insieme di tabelle)
Uno schema relazionale è costituito da un insieme di schemi di relazione e da un insieme di vincoli di integrità (sono possibili su valori associati alle relazioni)

---

# Def 3: Ennuple (righe della tabella)
Una ennupla t di Tj (tracciato dei campi) di coppie (Ai, Vi)
La cardinalità di una relazione è il numero delle sue ennuple.

```
t = (A1=V1, ... , An=Vn) (Assegnazioni Etichetta-Valore si fanno con =)
Tj = (A1:T1, ... , An:Tn) (Associazioni Etichetta-Tipo si fanno con :)
```



---
# Def 4: 3 Tipi importanti
1. Quali attributi non possono assumere un valore nullo
2. Quali attributi sono chiavi 
3. Quali attributi sono chiavi esterne

## Un istanza r di uno schema di relazione R è valida se rispetta tutti i vincoli definiti su R.