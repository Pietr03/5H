import pandas as pd

# Mappa dei continenti con i relativi paesi
continenti = {
    "Europa": ["Albania", "Andorra", "Austria", "Belgio", "Francia", "Germania", "Italia", "Regno Unito", "Spagna", "Svizzera"],
    "America Meridionale": ["Argentina", "Brasile", "Cile", "Colombia", "Perù", "Uruguay", "Venezuela"],
    "Asia": ["Afghanistan", "Arabia Saudita", "Cina", "Giappone", "India", "Israele", "Pakistan", "Turchia"],
    "Africa": ["Algeria", "Egitto", "Marocco", "Sudafrica", "Tunisia"],
    "Australia e Oceania": ["Australia", "Nuova Zelanda", "Papua Nuova Guinea"],
    "America Settentrionale e Centrale": ["Canada", "Messico", "Stati Uniti d'America", "Cuba", "Panama"]
}

def carica_dati(percorso_file):
    """Carica i dati dal file Excel e restituisce il DataFrame."""
    df = pd.read_excel(percorso_file)
    return df

def pulisci_dati(df):
    """Rimuove righe con valori non validi e converte le colonne necessarie."""
    # Rimuovi righe con valori NaN in qualsiasi colonna
    df = df.dropna()
    
    # Assicurati che la colonna 'ISCRITTI' sia numerica
    df['ISCRITTI'] = pd.to_numeric(df['ISCRITTI'], errors='coerce')

    # Rimuovi righe con NaN nella colonna 'ISCRITTI'
    df = df.dropna(subset=['ISCRITTI'])
    
    return df

def mappa_continente(paese):
    """Mappa un paese al suo continente."""
    for continente, paesi in continenti.items():
        if paese in paesi:
            return continente
    return "Altro"  # Se il paese non è in nessun continente, lo mappa come "Altro"

def raggruppa_per_continente(df):
    """Raggruppa i dati per continente e somma gli iscritti."""
    # Mappiamo ogni paese al suo continente
    df['Continente'] = df['Paese'].apply(mappa_continente)
    
    # Raggruppa per continente e somma gli iscritti
    df_gruppato = df.groupby('Continente')['ISCRITTI'].sum().reset_index()
    return df_gruppato

def esporta_risultati(df_gruppato, percorso_file_uscita):
    """Esporta i risultati in un nuovo file Excel."""
    df_gruppato.to_excel(percorso_file_uscita, index=False)

def main():
    # Percorso del file di input
    percorso_input = "/shared/dati/scuola/5H/Italiano/anagrafe/INT00041_ANAGRAFE_DEGLI_ITALIANI_RESIDENTI_ALL_ESTERO_-A.I.R.E.-_ed_2017.xls"
    
    # Percorso del file di output
    percorso_output = "/shared/dati/scuola/5H/Italiano/anagrafe/risultati_per_continente.xlsx"
    
    # Carica i dati
    df = carica_dati(percorso_input)
    
    # Pulisci i dati
    df_pulito = pulisci_dati(df)
    
    # Raggruppa per continente e somma gli iscritti
    df_gruppato = raggruppa_per_continente(df_pulito)
    
    # Esporta i risultati
    esporta_risultati(df_gruppato, percorso_output)
    
    print(f"Analisi completata. I risultati sono stati salvati in: {percorso_output}")

if __name__ == "__main__":
    main()
