/*
Numero degli studenti che partecipano alla manifestazione sportiva “corsaCampestre”
*/
SELECT
    COUNT(*) as numeroStudenti
FROM Iscrizioni
    INNER JOIN Manifestazione
        USING (cod_stud)
WHERE
    Manifestazione.descrizione = 'corsaCampestre';

/*
Elenco alfabetico degli allenatori della attività o una manifestazione sportiva che si chiama
“Costanziadi”
*/
SELECT cognome, nome
FROM Professori
    INNER JOIN Manifestazioni USING (codiceManifestazioni)
WHERE Manifestazioni.descrizione = 'Costanziadi'
ORDER BY cognome, nome;


/*
Elenco delle scuole (donominazione) con il numero di studenti che partecipano alle attività sportive.
*/

SELECT Istituti.denominazione, COUNT(*) AS numeroStudenti
FROM Studenti
    INNER JOIN Istituti USING(codiceIstituto)
    INNER JOIN Iscrizioni USING(codiceStudente)
GROUP BY Istituti.denominazione;

/*
Elenco delle scuole (con denominazione, indirizzo, telefono) con studenti che partecipano
alla manifestazione sportiva “costanziadi”
*/

SELECT
    Istituti.denominazione,
    Istituti.indirizzo,
    Istituti.telefono,
    COUNT(*) AS numeroStudenti
FROM Studenti
    INNER JOIN Istituti USING(codiceIstituto)
    INNER JOIN Iscrizioni USING(codiceStudente)
    INNER JOIN Manifestazioni USING (codiceManifestazioni)
WHERE codiceManifestazioni.descrizione = 'costanziadi'
GROUP BY Istituti.denominazione;


SELECT DISTINCT denominazione, indirizzo, telefono
FROM Istituti
INNER JOIN Professori USING(codiceIstituto)
INNER JOIN Manifestazioni USING (codiceManifestazione)
WHERE Manifestazioni.descrizione = "Corsa campestre";

/*
Numero degli studenti partecipanti di una determinata scuola (denominazione = “esempio”)
per ciascuno delle manifestazioni sportive.
*/

SELECT
    codiceManifestazioni.descrizione,
    COUNT(*) AS numeroStudenti
FROM Studenti
    INNER JOIN Istituti USING(codiceIstituto)
    INNER JOIN Iscrizioni USING(codiceStudente)
    INNER JOIN Manifestazioni USING (codiceManifestazioni)
WHERE Istituti.denominazione = 'esempio'
GROUP BY codiceManifestazioni.descrizione;



