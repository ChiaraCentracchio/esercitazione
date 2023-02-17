package com.ntt.demo2.demo2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canale {
    private String nome;
    private int numero;
    private Boolean stato;

}
