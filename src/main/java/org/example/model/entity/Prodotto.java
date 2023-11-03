package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prodotto {
    private int id;
    private String nome;
    private String descrizione;
    private int quantita;
    private double prezzo;
}
