package com.ntt.esercitazione21feb.repository;

import com.ntt.esercitazione21feb.domain.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
}