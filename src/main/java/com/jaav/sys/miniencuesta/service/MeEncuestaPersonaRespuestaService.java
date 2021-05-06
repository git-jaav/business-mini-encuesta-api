package com.jaav.sys.miniencuesta.service;

import com.jaav.sys.miniencuesta.model.api.MeEncuestaPersonaRespuestaJson;
import com.jaav.sys.miniencuesta.model.entities.MeEncuestaPersonaRespuesta;

import java.util.List;
import java.util.Optional;

public interface MeEncuestaPersonaRespuestaService {

    Optional<MeEncuestaPersonaRespuestaJson> obtenerPorId(Long id);
    int contarListado(MeEncuestaPersonaRespuesta objDao);
    List<MeEncuestaPersonaRespuestaJson> findAll();

    List<MeEncuestaPersonaRespuestaJson> findByTema(String tema);

    List<MeEncuestaPersonaRespuestaJson> findByTemaUsuario(String tema, String usuario);

    Optional<MeEncuestaPersonaRespuestaJson> save(MeEncuestaPersonaRespuestaJson objDao) throws Exception;
    Optional<MeEncuestaPersonaRespuestaJson> update(MeEncuestaPersonaRespuestaJson objDao);
    int delete(Long id) throws Exception;
}
