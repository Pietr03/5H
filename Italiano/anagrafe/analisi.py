import sys
import pandas as pd

def carica_dati(file_path):
    """Carica i dati dal file Excel."""
    try:
        df = pd.read_excel(file_path)
        return df
    except Exception as e:
        print(f"Errore nel caricamento del file: {e}")
        sys.exit(1)

continenti = {
"Europa" : [
    "Albania", "Andorra", "Austria", "Belgio", "Bielorussia", "Bosnia-Erzegovina", "Bulgaria", "Croazia",
    "Cipro", "Danimarca", "Estonia", "Finlandia", "Francia", "Germania", "Gibilterra", "Grecia", "Irlanda",
    "Islanda", "Italia", "San Marino", "Stato Città del Vaticano", "Kosovo", "Lettonia", "Liechtenstein",
    "Lituania", "Lussemburgo", "Macedonia del Nord", "Malta", "Moldova", "Monaco", "Montenegro", "Norvegia",
    "Paesi Bassi", "Polonia", "Portogallo", "Regno Unito", "Repubblica Ceca", "Romania", "Serbia", "Slovacchia",
    "Slovenia", "Spagna", "Svezia", "Svizzera", "Ucraina", "Ungheria"
],
"America Meridionale" : [
    "Argentina", "Bolivia", "Brasile", "Cile", "Colombia", "Ecuador", "Guyana", "Guyana Francese",
    "Paraguay", "Perù", "Suriname", "Uruguay", "Venezuela"
],
"Asia": [
    "Afghanistan", "Arabia Saudita", "Armenia", "Azerbaigian", "Bahrein", "Bangladesh", "Brunei", "Cambogia",
    "Cina", "Emirati Arabi Uniti", "Filippine", "Federazione Russa", "Georgia", "Giappone", "Giordania",
    "India", "Indonesia", "Iran", "Iraq", "Israele", "Kazakistan", "Kirghizistan", "Kuwait", "Laos", "Libano",
    "Malaysia", "Maldive", "Mongolia", "Myanmar", "Nepal", "Oman", "Pakistan", "Qatar", "Repubblica di Corea",
    "Repubblica Popolare Democratica di Corea", "Siria", "Singapore", "Sri Lanka", "Taiwan", "Tagikistan",
    "Territori della Autonomia Palestinese", "Thailandia", "Timor Orientale", "Turchia", "Turkmenistan",
    "Uzbekistan", "Vietnam", "Yemen"
],

"Africa" : [
    "Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi", "Capo Verde", "Camerun", "Ciad",
    "Comore", "Congo", "Costa d'Avorio", "Egitto", "Eritrea", "Eswatini", "Etiopia", "Gabon", "Gambia",
    "Ghana", "Guinea", "Guinea-Bissau", "Guinea Equatoriale", "Kenya", "Lesotho", "Liberia", "Libia",
    "Madagascar", "Malawi", "Mali", "Marocco", "Mauritania", "Mauritius", "Mayotte", "Mozambico", "Namibia",
    "Niger", "Nigeria", "Repubblica Centrafricana", "Repubblica Democratica del Congo", "Ruanda",
    "Sao Tomé e Principe", "Senegal", "Seychelles", "Sierra Leone", "Somalia", "Sudafrica", "Sud Sudan",
    "Sudan", "Tanzania", "Togo", "Tunisia", "Uganda", "Zambia", "Zimbabwe"
],

"Australia e Oceania": [
    "Australia", "Figi", "Isole Cook", "Isole Marshall", "Isole Salomone", "Isole Wallis e Futuna", "Kiribati",
    "Micronesia", "Nauru", "Nuova Caledonia", "Nuova Zelanda", "Palau", "Papua Nuova Guinea", "Samoa",
    "Tonga", "Tuvalu", "Vanuatu"
],
"America Settentrionale e Centrale": [
    "Antigua e Barbuda", "Anguilla", "Bahamas", "Barbados", "Belize", "Bermuda", "Canada", "Costa Rica",
    "Cuba", "Curaçao", "Dominica", "El Salvador", "Groenlandia", "Grenada", "Guatemala", "Haiti", "Honduras",
    "Giamaica", "Messico", "Nicaragua", "Panama", "Porto Rico", "Repubblica Dominicana", "Saint Barthelemy",
    "Saint Kitts e Nevis", "Saint Lucia", "Saint Martin", "Saint Pierre e Miquelon", "Saint Vincent e Grenadine",
    "Sint Maarten", "Stati Uniti d'America", "Trinidad e Tobago", "Isole Cayman", "Isole Turks e Caicos",
    "Isole Vergini Britanniche"
]
}

def raggruppa_dati(df):
    """Raggruppa i dati per continente."""
    risultati = {continente: df[df['Nazione'].isin(nazioni)] for continente, nazioni in continenti.items()}
    return risultati

def main():
    if len(sys.argv) < 2:
        print("Utilizzo: python script.py <percorso_file>")
        sys.exit(1)
    
    file_path = sys.argv[1]
    df = carica_dati(file_path)
    dati_raggruppati = raggruppa_dati(df)
    
    for continente, dati in dati_raggruppati.items():
        print(f"\n=== {continente} ===")
        print(dati.to_string(index=False))

if __name__ == "__main__":
    main()
