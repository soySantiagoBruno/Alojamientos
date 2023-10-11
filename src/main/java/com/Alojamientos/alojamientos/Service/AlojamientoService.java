package com.Alojamientos.alojamientos.Service;

import com.Alojamientos.alojamientos.Entity.Alojamiento;
import com.Alojamientos.alojamientos.Repository.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlojamientoService{
    @Autowired
    private AlojamientoRepository alojamientoRepository;

    public void save(Alojamiento alojamiento){
        alojamientoRepository.save(alojamiento);
    }

    public List<Alojamiento> getAlojamientos(){
        return alojamientoRepository.findAll();
    }

    public Alojamiento getAlojamientoById(Long id){
        return alojamientoRepository.findById(id).get();
    }

    public Alojamiento getAlojamientoByName(String name){
        return alojamientoRepository.findByName(name);
    }

    public void deleteAlojamientoById(Long id){
        Alojamiento alojamiento = getAlojamientoById(id);
        alojamientoRepository.delete(alojamiento);
    }
}
