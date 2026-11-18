package com.rueda.veterinaria.controller;

import com.rueda.veterinaria.model.Mascota;
import com.rueda.veterinaria.service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController {

    private MascotaService mascotaService;

    public MascotaController (MascotaService mascotaService) { this.mascotaService = mascotaService;}

    //Listar todas las mascotas
    @GetMapping
    public List<Mascota> verTodos() {return mascotaService.traerTodos();}

    //TRAER UNO
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> traerUno(@PathVariable int id){
        return mascotaService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody  Mascota mascota){
        Mascota nuevoMascota = mascotaService.guardar(mascota);
        return new ResponseEntity<>(nuevoMascota, HttpStatus.CREATED);
    }
}

