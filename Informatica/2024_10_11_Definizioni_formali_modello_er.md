# Schema relazionale 

## R:{T}
È una coppia formata da un nome di relazione R e da un tipo di relazione definito così:

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
# Ri:{Ti}; i = 1, ..., k   
Uno schema relazionale è costituito da un insieme di schemi di relazione e da un insieme di vincoli di integrità
