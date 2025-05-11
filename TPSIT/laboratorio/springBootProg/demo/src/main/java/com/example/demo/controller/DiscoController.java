package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Disco;

// Controller che gestisce l'API REST per i Dischi
@RestController
@RequestMapping("/api/dischi")

public class DiscoController {

private List<Disco> dischi = new ArrayList<>();

// Costruttore: inizializza alcuni dischi
public DiscoController() {
dischi.add(new Disco(1, "The Wall", "Pink Floyd"));
dischi.add(new Disco(2, "Thriller", "Michael Jackson"));
}

// Metodo GET: restituisce la lista di tutti i dischi
@GetMapping
public List<Disco> getAllDischi() {
return dischi;
}

@GetMapping("/{id}")
public Disco getDisco(@PathVariable int id) {
    for (Disco disco : dischi) {
        if (disco.getId() == id) {
            return disco;
        }
    }
    return null;
}

// Metodo POST: aggiunge un nuovo disco
@PostMapping
public Disco addDisco(@RequestBody Disco disco) {
dischi.add(disco);
return disco;
}

// Metodo PUT: aggiorna un disco esistente
@PutMapping("/{id}")
public Disco updateDisco(@PathVariable int id, @RequestBody Disco discoUpdate) {
for (Disco disco : dischi) {

if (disco.getId() == id) {
disco.setTitolo(discoUpdate.getTitolo());
disco.setArtista(discoUpdate.getArtista());
return disco;
}
}
return null; // se il disco non esiste
}

// Metodo DELETE: elimina un disco tramite id
@DeleteMapping("/{id}")
public void deleteDisco(@PathVariable int id) {
dischi.removeIf(disco -> disco.getId() == id);
}
}