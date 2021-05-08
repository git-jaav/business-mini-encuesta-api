package com.jaav.sys.miniencuesta.repository;


import com.jaav.sys.miniencuesta.model.entities.MeEncuestaPersonaRespuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeEncuestaPersonaRespuestaRepository extends CrudRepository<MeEncuestaPersonaRespuesta, Long>  {

    @Query(value = "select enResp from MeEncuestaPersonaRespuesta enResp " +
            "where enResp.meEncuestaAlternativa.enteCodigo =?1 ", nativeQuery = false)
    List<MeEncuestaPersonaRespuesta> findByEnteCodigo(String enteCodigo);


    @Query(value = "select enResp from MeEncuestaPersonaRespuesta enResp " +
            "where enResp.meEncuestaAlternativa.enteCodigo =?1 and  enResp.enperCodigoUsuario =?2",
            nativeQuery = false)
    List<MeEncuestaPersonaRespuesta> findByEnteCodigoAndUser(String enteCodigo, String usuario);

}
