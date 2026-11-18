package com.rueda.veterinaria.controller;

import com.rueda.veterinaria.model.Duenio;
import com.rueda.veterinaria.model.Mascota;
import com.rueda.veterinaria.service.DuenioService;
import com.rueda.veterinaria.service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duenio")
public class DuenioController {

    private final MascotaService mascotaService;
    private DuenioService duenioService;

    public DuenioController (DuenioService duenioService, MascotaService mascotaService) { this.duenioService = duenioService;
        this.mascotaService = mascotaService;
    }

    //Listar todas las mascotas
    @GetMapping
    public List<Duenio> verTodos() {return duenioService.traerTodos();}

    //TRAER UNO
    @GetMapping("/{id}")
    public ResponseEntity<Duenio> traerUno(@PathVariable int id){
        return duenioService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Duenio> guardar(@RequestBody  Duenio duenio){
        Duenio nuevoDuenio = duenioService.guardar(duenio);
        return new ResponseEntity<>(nuevoDuenio, HttpStatus.CREATED);
    }
}

