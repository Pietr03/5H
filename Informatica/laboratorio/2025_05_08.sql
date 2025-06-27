-- selezionare i dati dell'utente con il maggior numero di eventi registrati

SELECT COUNT(*) as numero_eventi_registrati, Utenti.* 
FROM Utenti
INNER JOIN EVENTI USING(id_utente)

GROUP BY id_utente
ORDER BY numero_eventi_registrati DESC
LIMIT 1;



-- Elenco degli eventi già svolti ordinati alfabeticamente
SELECT nome, nome_provincia
FROM Eventi INNER JOIN Provincia using(cod_provincia)
WHERE data <= CURRENT_TIMESTAMP
ORDER BY nome_provincia ASC;


-- Per ogni evento il voto medio ottenuto in ordine di categoria e titolo
SELECT AVG(Post.valutazione), Evento.nome, Categoria.nome
FROM EVENTO 
    INNER JOIN Categoria USING(id_categoria)
    INNER JOIN Post USING (id_evento)
ORDER BY Categoria.nome ASC, Evento.nome ASC;