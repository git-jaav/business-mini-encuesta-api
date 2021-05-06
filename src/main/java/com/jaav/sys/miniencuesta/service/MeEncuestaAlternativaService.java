package com.jaav.sys.miniencuesta.service;

import com.jaav.sys.miniencuesta.model.api.MeEncuestaAlternativaJson;
import com.jaav.sys.miniencuesta.model.entities.MeEncuestaAlternativa;

import java.util.List;
import java.util.Optional;

public interface MeEncuestaAlternativaService {

    Optional<MeEncuestaAlternativa> obtenerPorId(Integer id);

    public List<MeEncuestaAlternativaJson> listarTemaCodigo(String enteCodigo);

}
