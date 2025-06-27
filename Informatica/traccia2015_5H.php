<html>
<style>
        table {
            border-collapse: collapse;
            width: 70%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #333;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>

<head>
    <title> Filtro eventi per provincia</title>
    <!-- questo server per la connessione al db -->
    <?php
    $host = "mysql";
    $user = "giovanni_pandolfo";
    $db_pass = "pandolfo";
    $dbname = "giovanni_pandolfo_5";

    try{
        $connessione = new mysqli($host, $user, $db_pass, $dbname);
    }catch (Exception $e){
        die("Errore di connessione". "<br>" . $e->getMessage());
    }


    //controllo la connessione se è andata a buon fine
    if ($connessione === false) {
        //caso in cui la connessione fallisce
        die("Errore di connessione" . $connessione->connection_error);
    }


    //echo "connessione avvenuta con successio: " . $connessione->host_info;
    $parametro1 = $_POST["provincia"] ?? "";
    $parametro2 = $_POST["categoria"] ?? "";

    // catanzaro = 10
    $sql = "SELECT * 
                    FROM Evento INNER JOIN Provincia ON Provincia.cod_prov = Evento.id_prov
                                INNER JOIN Categoria ON Categoria.id = Evento.id_categoria
                    WHERE Provincia.nome='$parametro1' AND Categoria.descrizione='$parametro2'";

    //ora eseguo la query
    $risultato = $connessione->query($sql);
    ?>


</head>
<body>
    <h2> Eventi Trovati</h2>
    
    
    
    
    
    
    
    
    <?php
        if ($risultato->num_rows > 0) {
        // Stampa ogni riga
        while ($riga = $risultato->fetch_assoc()) {
            echo "città: " . $riga["citta"] . " - data: " . $riga["data"] . "<br>";
        }
        } else {
            echo "0 risultati";
        }
    ?>
</body>
</html>