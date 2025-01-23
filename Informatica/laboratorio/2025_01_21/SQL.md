```SQL
CREATE TABLE Bicicletta (
  id_bici INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_tipo INTEGER, 
  FOREIGN KEY (id_tipo) REFERENCES TipoBici(id_tipo)
  	ON DELETE NO ACTION
  	ON UPDATE NO ACTION,
  marca VARCHAR(15) NOT NULL,
  modello VARCHAR(15) NOT NULL,
  prezzo DECIMAL(8,2) NOT NULL
)
```


```SQL
CREATE TABLE TipoBici(
  id_tipo INTEGER PRIMARY KEY AUTO_INCREMENT,
  descrizione VARCHAR(30) DEFAULT ''
)
```


```SQL
INSERT INTO TipoBici(descrizione)
VALUES 
	('Mountain bike'),
    ('Da corsa')

```


```SQL
INSERT INTO Bicicletta (id_tipo, marca, modello, prezzo)
VALUES 
	(1, 'KTM', 'Duke 390', 3000),
	(2, 'YAMAHA', 'MT-125', 4000),
	(1, 'VELOX', 'KZ 125', 499),
	(2, 'VELOX', 'KZ 300', 5000)
```


```SQL
SELECT * FROM Bicicletta WHERE marca = 'VELOX' AND prezzo < 500;
```


```SQL
SELECT * FROM Bicicletta WHERE id_tipo = 1;
```


```SQL
SELECT marca FROM Bicicletta WHERE prezzo >1000;
```