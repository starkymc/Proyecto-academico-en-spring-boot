package com.proyecto.web.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.proyecto.web.entidad.Platos;


@Repository
public interface PlatosdatosRepositorio extends CrudRepository<Platos, Integer> {
	

}
