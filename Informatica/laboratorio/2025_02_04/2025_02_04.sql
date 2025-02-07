CREATE TABLE Dipartimenti (
  id_dipartimento INTEGER AUTO_INCREMENT PRIMARY KEY,
  descrizione VARCHAR(30) NOT NULL,
  sede VARCHAR(15) DEFAULT 'centrale',
  UNIQUE (descrizione)
  );



CREATE TABLE Impiegati (
  id_impiegato INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(15) NOT NULL,
  cognome VARCHAR(15) NOT NULL,
  residenza VARCHAR(30) DEFAULT 'NOCERA',
  stipendio DECIMAL(9,2),
  id_dipartimento INTEGER,
  FOREIGN KEY (id_dipartimento) REFERENCES Dipartimenti(id_dipartimento)
  		ON DELETE SET NULL
  		ON UPDATE NO ACTION,
  CHECK (stipendio >= 0),
  UNIQUE (cognome, nome, id_dipartimento)
  );
  



CREATE TABLE Progetti (
  cod_prog INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(20) NOT NULL,
  durata INTEGER NOT NULL,
  budget DECIMAL(9,2),
  CHECK ( durata >= 0)
  );




CREATE TABLE Partecipazione (
  id_impiegato INTEGER,
  cod_prog INTEGER,
  ruolo VARCHAR(20),
  percentuale INTEGER,
  PRIMARY KEY (id_impiegato, cod_prog),
  FOREIGN KEY (id_impiegato) REFERENCES Impiegati(id_impiegato)
  				on delete no ACTION
  				on UPDATE no action,
  FOREIGN KEY (cod_prog) REFERENCES Progetti(cod_prog) -- qui ho cancellato le due righe 
  			-- perché vengono lasciate a defalut. Sono entrabe uguali
  );






insert into Dipartimenti
(descrizione, sede)
VALUES
('Scienze', 'Roma'),
('Informatico', 'Napoli'),
('Fisica', 'Palermo'),
('Meccanica', 'Milano')
;





INSERT INTO Impiegati (nome, cognome, residenza, stipendio, id_dipartimento)
VALUES
  ('Luca', 'Bianchi', 'Roma', 1500.00, 1),
  ('Luca', 'Bianchi', 'Milano', 2500.00, 3),
  ('Giulia', 'Verdi', 'Torino', 1200.75, 3),
  ('Francesco', 'Neri', 'Napoli', 1700.20, 2),
  ('Sara', 'Gialli', 'Firenze', 1450.50, 1),
  ('Antonio', 'Blu', 'Bologna', 1600.00, 4),
  ('Maria', 'Arancioni', 'Palermo', 1300.00, 3),
  ('Paolo', 'Marrone', 'Venezia', 1250.25, 2),
  ('Elena', 'Rossi', 'Milano', 1400.00, 4),
  ('Stefano', 'Azzurri', 'Palermo', 1350.00, 3),
  ('Alessandra', 'Grigi', 'Palermo', 1550.75, 1),
  ('Marco', 'Bianco', 'Torino', 1400.00, 2),
  ('Elisa', 'Verde', 'Napoli', 1550.50, 3),
  ('Giovanni', 'Rossi', 'Roma', 1600.75, 1);



insert into Progetti
(cod_prog, nome, durata, budget)
VALUES
(1, 'progetto grande',5,500000.00),
(2, 'progetto medi', 3, 250000.00),
(3, 'progetto piccolo', 1, 150000.00),
(4, 'progetto innovativo', 4, 300000.00),
(5, 'progetto strategico', 2, 200000.00);




INSERT INTO Partecipazione (id_impiegato, cod_prog, ruolo, percentuale)
VALUES
  -- Progetto 1
  (1, 1, 'Direttore', 50),
  (2, 1, 'Tecnico', 30),
  (3, 1, 'Finanziario', 20),
  
  -- Progetto 2
  (4, 2, 'Direttore', 40),
  (5, 2, 'Tecnico', 40),
  (6, 2, 'Amministrativo', 20),

  -- Progetto 3
  (7, 3, 'Direttore', 60),
  (8, 3, 'Tecnico', 40),

  -- Nuovi progetti con nuovi impiegati
  (9, 4, 'Direttore', 50),
  (10, 4, 'Tecnico', 50),
  (11, 5, 'Amministrativo', 30),
  
  (12, 5, 'Direttore', 60),
  (3, 5, 'Tecnico', 40);