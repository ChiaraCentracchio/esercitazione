package com.ntt.demo2.demo2.controller;
import com.ntt.demo2.demo2.domain.Canale;
import com.ntt.demo2.demo2.domain.Monitor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
public class Monitorcontroller {
    @GetMapping("/monitor")
    public ResponseEntity<Monitor> returnCanale() {
        Monitor monitor= new Monitor();
        monitor.setColore("rosa");
        monitor.setMarca("huawei");
        return new ResponseEntity<>(monitor,HttpStatus.OK);

    }
    @PostMapping("/monitor")
    public ResponseEntity<?> createMonitor(@RequestBody Monitor monitor){
        Monitor monitor1 = monitor;
        return new ResponseEntity<>(monitor1, HttpStatus.CREATED);
    }

}
