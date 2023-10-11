package com.Alojamientos.alojamientos.Repository;

import com.Alojamientos.alojamientos.Entity.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento,Long> {

    //esto crea una finder method sin tener que escribir un SQL queries (Data JPA lo hace por detrás)
    Alojamiento findByName(String name);
}
