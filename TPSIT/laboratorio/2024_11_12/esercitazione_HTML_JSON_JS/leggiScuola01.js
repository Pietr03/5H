const percorsoJSON =
    "http://127.0.0.1:5500/TPSIT/laboratorio/2024_11_12/esercitazione_HTML_JSON_JS/leggiScuola01.json";

const headTabella = `<thead> <tr>
<th>Classe</th>
    <th>Numero studenti</th>
    <th>Numero materie</th>
    <th>Indirizzo studio</th>
</tr></thead>`;

const fillTabella = (data) => {
    const tabella = document.querySelector("#dati");
    tabella.innerHTML += headTabella;

    let righe = ``;
    data.classi.forEach((classe, index) => {
        righe += `
        <tr>
        <td>${classe.classe}</td>
        <td>${classe.n_studenti}</td>
        <td>${classe.n_materie}</td>
        <td>${classe.indirizzo_studio}</td>
    </tr>`;
    });
    tabella.innerHTML += `<tbody>${righe}</tbody>`;
};

window.onload = async () => {
    let data;
    try {
        const tempData = await fetch(percorsoJSON);
        if (!tempData.ok) {
            throw new Error(`Errore HTTP! Status: ${tempData.status}`);
        }
        data = await tempData.json();
    } catch (error) {
        console.error(
            "Si sono verificati degli errori nel caricamento del file:",
            error
        );
        return;
    }

    fillTabella(data);
};
