package com.example.demo;
// Classe modello rappresentante un Disco Musicale
public class Disco {
    private int id;
    private String titolo;
    private String artista;
    
    // Costruttore
    public Disco(int id, String titolo, String artista) {
    this.id = id;
    this.titolo = titolo;
    this.artista = artista;
    }
    
    // Getter e Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTitolo() { return titolo; }
    public void setTitolo(String titolo) { this.titolo = titolo; }
    
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    }