package com.ntt.esercitazione21feb.controller;

import com.ntt.esercitazione21feb.domain.Corso;
import com.ntt.esercitazione21feb.repository.CorsoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Corsocontroller {
    @Autowired
    CorsoRepository corsoRepository;
    @GetMapping("/corso")
    public ResponseEntity<?> returnCorso() {
        Corso corso= new Corso();
        //corso.setId(1L);
        //corso.setNomecorso("Analisi Matematica 1");
        //corso.setDescrizionecorso("Numeri complessi");
        List<Corso> listaCorsi= corsoRepository.findAll();
        return new ResponseEntity<>(listaCorsi, HttpStatus.OK);
        //return new ResponseEntity<>(listaCorsi.size(), HttpStatus.OK);

    }
    @PostMapping("/slide3")
    public ResponseEntity<?> controlloprefisso(@RequestBody Corso corso) {
        if(corso.getNomecorso().substring(0,6).equals("corso_") && corso.getNomecorso().length()> 7) {
            Corso corso3= corsoRepository.save(corso);
            return new ResponseEntity<>(corso, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/corso")
    public ResponseEntity<?> createCorso(@RequestBody Corso corso){
        //Corso corso1 = corso;
        List<Corso> lista= corsoRepository.findAll();
        boolean b= false;
        for(Corso c: lista) {
            if(c.getId() == corso.getId()) {
                b = true;
            }

        }
        if(b) {
            return new ResponseEntity<>("error:duplicate",HttpStatus.OK);
        }
        else {
            Corso corso1=corsoRepository.save(corso);
            return new ResponseEntity<>(corso1, HttpStatus.CREATED);
        }
    }
    @PutMapping("/corso")
    public ResponseEntity<?> updateCorso(@PathVariable("id") long id, @RequestBody Corso corso) {
        Corso corso2=new Corso(1L,"Storia","Prima guerra mondiale");
        if(corso2.getId()==id)
            return new ResponseEntity<>(corso2, HttpStatus.OK);
        return new ResponseEntity<>(corso, HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/corso/{id}")
    public ResponseEntity<HttpStatus> deleteCorso(@PathVariable("id") long id) {
        corsoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/corso/{id}")
    public ResponseEntity<?> visualizzaCorso(@PathVariable long id, @RequestBody Corso corso) {
        List<Corso> listaCorsi= corsoRepository.findAll();
        for (Corso c: listaCorsi
             ) {if(c.getId() == id)
            return new ResponseEntity<>(c,HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/corsi_")
    public ResponseEntity<?> contaprefisso() {
        List<Corso> corsi= corsoRepository.findAll();
        int count=0;
        for(Corso a: corsi) {
            if(a.getNomecorso().substring(0,6).equals("corso_")) {
                count++;
            }

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/slide7")
    public ResponseEntity<List<Corso>> returnEndpointDescrizione(){
        List<Corso> corso_list = corsoRepository.findAll();
        for (Corso corsoIter : corso_list) {
            if (corsoIter.getNomecorso().length() < 20) {
                return new ResponseEntity<>(corso_list, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
