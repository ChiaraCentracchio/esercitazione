package com.ntt.demo2.demo2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data

public class Tv extends Monitor {
    private ArrayList<Canale>
            listaCanale= new ArrayList<Canale>();
    public Tv(String marca, String colore, ArrayList<Canale> listaCanale) {
        super(marca, colore);
        this.listaCanale = listaCanale;
    }

    public void aggiungiCanale(Canale canale) {
        listaCanale.add(canale);
    }
    public void rimuoviCanale(String nome) {
        for(int i=0; i< listaCanale.size(); i++) {
            if (listaCanale.get(i).getNome().equals(nome)) {
                listaCanale.remove(i);
            }
        }
    }
    public void risintonizza()
    {    Canale canale = listaCanale.get(0);
        canale.setStato(true);
        listaCanale.set(0, canale);
        for(int i = 1; i < listaCanale.size(); i++) {
            canale = listaCanale.get(i);
            canale.setStato(false);
            listaCanale.set(i, canale);
        }
    }
}
