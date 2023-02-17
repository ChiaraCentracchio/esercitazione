package com.ntt.demo2.demo2.controller;
import com.ntt.demo2.demo2.domain.Canale;
import com.ntt.demo2.demo2.domain.Monitor;
import com.ntt.demo2.demo2.domain.Tv;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@RestController
public class Tvcontroller {
    @GetMapping("/tv")
    public ResponseEntity<Tv> returnTv() {
        Tv tv= new Tv("samsung",
                "blu",
                new ArrayList<Canale>(Arrays.asList(new Canale("Rai 1",1,true),new Canale("Rai 2",2,false))));

        return new ResponseEntity<>(tv,HttpStatus.OK);

    }
    @PutMapping("/aggcanale")
    public ResponseEntity<Tv> aggCanale(@RequestBody Canale canale){
        Tv tv = new Tv("Blu", "Samsung", new ArrayList<Canale>());
        tv.aggiungiCanale(canale);
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }
    @PutMapping("/risintonizza")
    public ResponseEntity<Tv> risintonizza (@RequestBody Canale canale) {
        ArrayList<Canale> lista= new ArrayList<>();
        lista.add(new Canale("Real time",31, false));
        lista.add(new Canale("Sky1", 101,false));
        Tv tv = new Tv("Rosso", "LG", lista);
        tv.risintonizza();
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }


    @DeleteMapping("/rimCanale")public ResponseEntity<Tv> rimCanale(@RequestBody String nome){
        ArrayList<Canale> lista= new ArrayList<>();
        lista.add(new Canale("Real time",31, false));
        lista.add(new Canale("Sky1", 101,false));
        Tv tv = new Tv("Rosso", "LG", lista);
        tv.rimuoviCanale(nome);
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }
}
