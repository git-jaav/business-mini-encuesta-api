package com.jaav.sys.miniencuesta.repository;

import com.jaav.sys.miniencuesta.model.entities.MeEncuestaAlternativa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeEncuestaAlternativaRepository extends CrudRepository<MeEncuestaAlternativa, Integer> {

    List<MeEncuestaAlternativa> findByEnteCodigoAndEnaltEstado(String enteCodigo, String status);

}
