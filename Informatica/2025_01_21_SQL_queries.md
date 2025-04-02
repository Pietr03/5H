<link rel="stylesheet" href="../style.css">

<label style="position:static;" for="tema-scuro">Tema scuro
<input type="checkbox" id="tema-scuro"></input>
</label>

# SQL


```SQL
CREATE TABLE Dipartimenti (
  id_dipartimento INTEGER AUTO_INCREMENT PRIMARY KEY,
  descrizione VARCHAR(30) NOT NULL,
  sede VARCHAR(30) DEFAULT 'Sede centrale',
  Unique (descrizione)
)
```

```SQL
CREATE TABLE Impiegati(
  id_impiegato INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(15) NOT NULL,
  cognome VARCHAR(15) NOT NULL,
  residenza VARCHAR(30) DEFAULT 'Nocera terinese',
  stipendio DECIMAL(8,2), 
  id_dipartimento INTEGER,
  CONSTRAINT FK_id_dipartimento 
  	FOREIGN KEY (id_dipartimento)
		REFERENCES Dipartimenti(id_dipartimento)
  			On DELETE set NULL
  			ON UPDATE NO ACTION,
  CHECK (stipendio >= 0)
)
```

```SQL
--DROP TABLE Progetti;

CREATE TABLE IF NOT EXISTS Progetti(
  cod_prog INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(15) NOT NULL,
  cognome VARCHAR(15) NOT NULL,
  durata INTEGER DEFAULT 0,
  budget DECIMAL(8,2),
  CHECK (durata >= 0)
  );

ALTER TABLE Progetti (
  ADD constraint check_durata CHECK (durata >= 0)
);
```

```SQL
--DROP TABLE demo;


CREATE TABLE Partecipazioni(
  id_impiegato INTEGER,
  cod_prog INTEGER,
  ruolo VARCHAR(10) NOT NULL,
  percentuale INTEGER,
  
  PRIMARY KEY (id_impiegato, cod_prog),
  
  CONSTRAINT FK_id_impiegato FOREIGN KEY (id_dipartimento)
  	REFERENCES Impiegati(id_impiegato),
  
  -- ON DELETE NO ACTION è il default
  
  CONSTRAINT FK_cod_prog FOREIGN KEY (cod_prog)
  	REFERENCES Progetti(cod_prog),
  
  CHECK (percentuale >= 0)
);
```

```SQL
ALTER TABLE Impiegati
	ADD nascita DATE;
```

```SQL
ALTER TABLE Dipartimenti
	ADD Via VARCHAR(10) DEFAULT 'Via Taldei';
    
ALTER TABLE Dipartimenti
	DROP Via;
```

```SQL
CREATE UNIQUE INDEX IndicePerNome
	ON Impiegati (cognome, nome)

DROP INDEX IndicePerNome ON Impiegati
```

```SQL
INSERT INTO Impiegati 
  (nome, cognome, stipendio, id_dipartimento)
  VALUES
  ('Giovanni', 'Pandolfo', 1000, 10 )

```

```SQL
SELECT * FROM Impiegati;
```

```SQL
UPDATE Impiegati 
SET stipendio = 100.11
WHERE nome = 'Pietro';

SELECT nome, stipendio 
	FROM Impiegati 
    WHERE nome = 'Pietro';
```

```SQL
INSERT INTO Impiegati
  (nome, cognome, residenza, stipendio, id_dipartimento)
VALUES
  ('Giulia', 'Verdi', 'Torino', 1500.50, 1)
```

## Comandi importanti

**ALTER TABLE**, data una tabella, ne altera i vincoli e i campi.
```sql
ALTER TABLE Impiegati
  ADD nascita DATE,
  DROP nascita;
```


**UPDATE**, data una riga, permette di modificare i dati salvati.
```SQL
UPDATE Impiegati 
SET stipendio = NULL
WHERE nome = 'Giulia'
```

**ALL** e **DISTINCT**, permettono di mantenere o eliminare i dati duplicati.

```SQL
SELECT ALL nome,cognome FROM Impiegati WHERE nome = 'Giulia';

SELECT DISTINCT nome,cognome FROM Impiegati WHERE nome = 'Giulia';
```

**AS**, si usa per rinominare una colonna

```SQL
SELECT nome AS soprannome FROM Impiegati;

SELECT nome AS soprannome, stipendio AS netto, stipendio * 1.22 AS lordo, (stipendio * 1.22) - stipendio AS tasse FROM Impiegati;

```


**NULL** nella ricerca
```SQL
WHERE stipendio = NULL  -- Non funziona
WHERE stipendio IS NULL -- Funziona
```

Nella select, il primo parametro è usato per la proiezione, il secondo per la join, il testo per la selezione


**ORDER BY**, ordina i risultati della nostra interrogazione in base ad una o più colonne.
- Con **DESC**, DESCENDING, si ordinano in modo decrescente
- Con **ASC**, ASCENDING, valore default, si ordinano in modo crescente
```sql
SELECT * 
FROM Impiegati 
ORDER BY cognome DESC, nome ASC; --oppure con 3, seleziona la terza colonna
``` 

**GROUP BY**, ci permette di separare in settori diversi i pezzi della nostra tabella, ed eseguire separatamente le funzioni di aggregazione su ogni sezione, per un dato campo.
```sql
SELECT SUM(stipendio), COUNT(*) AS numeroDipendenti
FROM Impiegati INNER JOIN Dipartimenti USING(id_dipartimento)
WHERE descrizione = 'Infomatico';

SELECT SUM(stipendio), COUNT(*) AS numeroDipendenti
FROM Impiegati INNER JOIN Dipartimenti USING(id_dipartimento)
WHERE descrizione = 'Meccanico';

SELECT SUM(stipendio), COUNT(*) AS numeroDipendenti
FROM Impiegati INNER JOIN Dipartimenti USING(id_dipartimento)
WHERE descrizione = 'Scienze';
```
#### OPPURE

```sql
SELECT descrizione, SUM(stipendio), COUNT(*) AS numeroDipendenti
FROM Impiegati INNER JOIN Dipartimenti USING(id_dipartimento)
GROUP BY descrizione;
```
**LIKE**

**HAVING**
```sql
SELECT 
```

**COUNT**
Conta il numero di occorrenze _(record restituiti)_ restituiti nell'operazione

```sql
SELECT 
  COUNT(id_impiegato) as conteggioRoma 
FROM 
  Impiegati 
  INNER JOIN Dipartimenti
  USING (id_dipartimento) Dipartimenti
WHERE 
  sede = 'Roma;
```
----

## JOIN ESTERNO
### Left
La tabella risultante conterrà tutte le righe, incluse tutte le righe della tabella di sinistra, riempiendo i campi vuoti con ```NULL```

### Right 
La tabella risultate conterrà tutte le righe, incluse quelle della colonna di destra che non hanno corrispondenza nella prima tabella, riempiendo i campi di quest'ultima con ```NULL```

### FULL
Genera righe con campi ```NULL``` dove ogni riga di una tabella non ha una corrispondenza nell'altra tabella.

```sql
-- JOIN ESTERNA

SELECT nome, cognome, sede FROM Impiegati RIGHT JOIN Dipartimenti USING (id_dipartimento);
```

---

## Funzioni di aggregazione
Agiscono su una spefica colonna, e restituiscono un solo valore.

Appaiono solo e soltanto nelle SELECT e nelle HAVING, alcuni esempi sono:
- COUNT
- SUM
- AVG
- MIN
- MAX

Es: qual è la persona che prende lo stipendio più alto? 
Si usa la funzione MAX()

### Count
Conta il numero di occorrenze.

Tra le sue parentesi accetta i nomi delle colonne, e ne seleziona solo quelli che non sono nulli.

```sql
SELECT COUNT(*) AS numeroDipendenti
FROM Impiegati INNER JOIN Dipartimenti USING(id_dipartimento)
WHERE Dipartimenti.descrizione = 'Informatico';
```
```sql
SELECT 
  COUNT(*) AS nDipendenti,
  COUNT(*) - COUNT(id_dipartimento) AS senzaDipartimento
FROM Impiegati;
```
### AVG
Fa la media aritmetica
```sql
SELECT AVG(stipendio) as stipendioMedio
FROM Impiegati;
```

### MAX e MIN
Analizzano i record e li ordinano alfabeticamente, min restituirà il primo (che comincia con 0 oppure A), MAX prenderà l'ultimo (con lettere come la Z o i simboli)


## Combinare più tabelle
```sql
SELECT id_impiegato, cognome, descrizione, percentuale
FROM Impiegati 
  INNER JOIN Dipartimenti USING(id_dipartimento)
  INNER JOIN Partecipazioni USING(id_impiegato)
```

----

# SQL - Appunti

## Definizione delle Tabelle

### Tabella Dipartimenti
```SQL
CREATE TABLE Dipartimenti (
  id_dipartimento INTEGER AUTO_INCREMENT PRIMARY KEY,
  descrizione VARCHAR(30) NOT NULL,
  sede VARCHAR(30) DEFAULT 'Sede centrale',
  UNIQUE (descrizione)
);
```

### Tabella Impiegati
```SQL
CREATE TABLE Impiegati(
  id_impiegato INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(15) NOT NULL,
  cognome VARCHAR(15) NOT NULL,
  residenza VARCHAR(30) DEFAULT 'Nocera Terinese',
  stipendio DECIMAL(8,2),
  id_dipartimento INTEGER,
  CONSTRAINT FK_id_dipartimento
    FOREIGN KEY (id_dipartimento)
    REFERENCES Dipartimenti(id_dipartimento)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CHECK (stipendio >= 0)
);
```

### Tabella Progetti
```SQL
CREATE TABLE IF NOT EXISTS Progetti(
  cod_prog INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(15) NOT NULL,
  cognome VARCHAR(15) NOT NULL,
  durata INTEGER DEFAULT 0,
  budget DECIMAL(8,2),
  CHECK (durata >= 0)
);
```

### Tabella Partecipazioni
```SQL
CREATE TABLE Partecipazioni(
  id_impiegato INTEGER,
  cod_prog INTEGER,
  ruolo VARCHAR(10) NOT NULL,
  percentuale INTEGER,
  PRIMARY KEY (id_impiegato, cod_prog),
  CONSTRAINT FK_id_impiegato FOREIGN KEY (id_impiegato)
    REFERENCES Impiegati(id_impiegato),
  CONSTRAINT FK_cod_prog FOREIGN KEY (cod_prog)
    REFERENCES Progetti(cod_prog),
  CHECK (percentuale >= 0)
);
```

## Modifiche alle Tabelle

### Aggiunta e Rimozione di Colonne
```SQL
ALTER TABLE Impiegati ADD nascita DATE;
ALTER TABLE Dipartimenti ADD Via VARCHAR(10) DEFAULT 'Via Taldei';
ALTER TABLE Dipartimenti DROP COLUMN Via;
```

### Indici
```SQL
CREATE UNIQUE INDEX IndicePerNome ON Impiegati (cognome, nome);
DROP INDEX IndicePerNome ON Impiegati;
```

## Operazioni sui Dati

### Inserimento
```SQL
INSERT INTO Impiegati (nome, cognome, stipendio, id_dipartimento)
VALUES ('Giovanni', 'Pandolfo', 1000, 10);

INSERT INTO Impiegati (nome, cognome, residenza, stipendio, id_dipartimento)
VALUES ('Giulia', 'Verdi', 'Torino', 1500.50, 1);
```

### Aggiornamento
```SQL
UPDATE Impiegati
SET stipendio = 100.11
WHERE nome = 'Pietro';

UPDATE Impiegati
SET stipendio = NULL
WHERE nome = 'Giulia';
```

### Selezione
```SQL
SELECT * FROM Impiegati;
SELECT nome, stipendio FROM Impiegati WHERE nome = 'Pietro';
```

## Comandi Importanti

### ALL e DISTINCT
```SQL
SELECT ALL nome, cognome FROM Impiegati WHERE nome = 'Giulia';
SELECT DISTINCT nome, cognome FROM Impiegati WHERE nome = 'Giulia';
```

### Alias (AS)
```SQL
SELECT nome AS soprannome FROM Impiegati;
SELECT nome AS soprannome, stipendio AS netto, stipendio * 1.22 AS lordo,
       (stipendio * 1.22) - stipendio AS tasse FROM Impiegati;
```

### NULL nella Ricerca
```SQL
WHERE stipendio = NULL  -- Non funziona
WHERE stipendio IS NULL; -- Funziona
```

### ORDER BY
```SQL
SELECT * FROM Impiegati ORDER BY cognome DESC, nome ASC;
```

### GROUP BY
```SQL
SELECT descrizione, SUM(stipendio), COUNT(*) AS numeroDipendenti
FROM Impiegati INNER JOIN Dipartimenti USING(id_dipartimento)
GROUP BY descrizione;
```

## JOIN ESTERNO

### LEFT JOIN
```SQL
SELECT nome, cognome, sede FROM Impiegati LEFT JOIN Dipartimenti USING (id_dipartimento);
```

### RIGHT JOIN
```SQL
SELECT nome, cognome, sede FROM Impiegati RIGHT JOIN Dipartimenti USING (id_dipartimento);
```

### FULL JOIN
```SQL
SELECT nome, cognome, sede FROM Impiegati FULL JOIN Dipartimenti USING (id_dipartimento);
```

## Funzioni di Aggregazione

### COUNT
```SQL
SELECT COUNT(*) AS numeroDipendenti FROM Impiegati;
```

### AVG
```SQL
SELECT AVG(stipendio) AS stipendioMedio FROM Impiegati;
```

### MAX e MIN
```SQL
SELECT MAX(stipendio) AS stipendioMassimo FROM Impiegati;
SELECT MIN(stipendio) AS stipendioMinimo FROM Impiegati;
```

## Combinare Più Tabelle
```SQL
SELECT id_impiegato, cognome, descrizione, percentuale
FROM Impiegati
  INNER JOIN Dipartimenti USING(id_dipartimento)
  INNER JOIN Partecipazioni USING(id_impiegato);
```

```sql
--- Elenca quanti dipendenti ha ogni città, in ordine di città più numerosa
SELECT residenza, count(*) AS numeroDipendenti
From Impiegati
GROUP BY residenza
ORDER BY numeroDipendenti
```


**HAVING**
Controlla il risultato di un'aggregazione.

```sql
SELECT descrizione, COUNT(*) AS quanti, SUM(stipendio) AS costo
From Impiegati INNER JOIN Dipartimenti USING(id_dipartimento)
GROUP BY descrizione
HAVING COUNT(*) >= 4
```


## Between
Controlla se un valore è incluso in un intervallo di valori, inclusi gli estremi.

```sql
SELECT *
FROM Impiegati
WHERE stipendio BETWEEN 1000 AND 2000;
```

## In
Controlla se un valore appartiene ad un insieme di valori, può essere preceduto dalla parola NOT.

```sql
SELECT *
FROM Impiegati
WHERE nome IN ('Giovanni', 'Pietro', 'Giulia') AND nome NOT IN ('Francesco', 'Stefano');

```

## Like
Serve per verificare la presenza di un pattern all'interno di una stringa, con le **"RegEx"** o **"espressioni regolari"**.

Caratteri speciali:
- %: corrisponde a qualsiasi sequenza di caratteri
- _: corrisponde a un singolo carattere 
- \[carattere\]**: corrisponde al carattere specificato
- \[^carattere\]: corrisponde a tutti i caratteri tranne il carattere specificato
- \%: corrisponde a qualsiasi sequenza di caratteri
- \_: corrisponde a un singolo carattere

```sql
SELECT *
FROM Impiegati
WHERE cognome LIKE 'P%';
``` 

# Ordine di utilizzo degli STATEMENT

1. SELECT
2. FROM
3. WHERE
4. GROUP BY
5. HAVING
6. ORDER BY