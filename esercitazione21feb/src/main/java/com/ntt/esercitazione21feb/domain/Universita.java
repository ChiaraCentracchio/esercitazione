package com.ntt.esercitazione21feb.domain;

import jakarta.persistence.*;

import java.util.*;


@Entity
@Table(name = "universita")
public class Universita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    




}