package com.rueda.veterinaria.service;

import com.rueda.veterinaria.model.Duenio;
import com.rueda.veterinaria.model.Mascota;
import com.rueda.veterinaria.repository.DuenioRepository;
import com.rueda.veterinaria.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenioService {

    private DuenioRepository duenioRepository;

    public DuenioService( DuenioRepository duenioRepository ){
        this.duenioRepository = duenioRepository;
    }

    //TRAER TODOS
    public List<Duenio> traerTodos(){
        return duenioRepository.findAll();
    }

    //TRAER UNO
    public Optional<Duenio> traerUno(int id){
        return duenioRepository.findById(id);
    }

    //GUARDAR
    public Duenio  guardar (Duenio duenio){
        return duenioRepository.save(duenio);
    }
}
