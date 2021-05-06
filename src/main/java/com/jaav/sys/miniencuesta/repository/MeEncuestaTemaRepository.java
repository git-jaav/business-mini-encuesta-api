package com.jaav.sys.miniencuesta.repository;

import com.jaav.sys.miniencuesta.model.entities.MeEncuestaTema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeEncuestaTemaRepository extends CrudRepository<MeEncuestaTema, String> {
}
