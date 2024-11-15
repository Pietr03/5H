const percorsoJSON =
    "http://127.0.0.1:5500/TPSIT/laboratorio/2024_11_12/esercitazione_HTML_JSON_JS/data.json";

let data;

fetch(percorsoJSON)
    .then((response) => {
        if (!response.ok) {
            throw new Error(`Errore HTTP! Status: ${response.status}`);
        }
        return response.json();
    })
    .then((fetchedData) => {
        data = fetchedData;
        console.log(data); // Qui hai accesso ai dati JSON
    })
    .catch((error) => {
        console.error(
            "Si è verificato un errore durante il caricamento del file:",
            error
        );
    });

/*
const percorsoJSON = "./data.json";
const request = new XMLHttpRequest();
request.open("GET", percorsoJSON, true);
request.responseType = "json";
request.send();

let data;

request.onload = function () {
    data = request.response;
    console.log(data);
};
*/

const tabella = document.getElementById("dati");

const headTabella = ` <tr>
        <th>Classe</th>
        <th>Numero studenti</th>
        <th>Numero materie</th>
        <th>Indirizzo studio</th>
    </tr>`;

tabella.innerHTML += headTabella;

tabella.array.forEach((classe) => {
    data.tabella.innerHTML += `<tr>
        <td>${classe.classe}</td>
        <td>${classe.N.Studenti}</td>
        <td>${classe.N.Materie}</td>
        <td>${classe.indirizzo_studio}</td>
    </tr>`;
});
