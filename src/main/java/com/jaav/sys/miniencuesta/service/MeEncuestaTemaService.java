package com.jaav.sys.miniencuesta.service;

import com.jaav.sys.miniencuesta.model.api.MeEncuestaTemaJson;
import com.jaav.sys.miniencuesta.model.entities.MeEncuestaTema;

import java.util.List;
import java.util.Optional;

public interface MeEncuestaTemaService {

    Optional<MeEncuestaTemaJson> obtenerPorId(String id);
    List<MeEncuestaTemaJson> listar(MeEncuestaTema objDao,boolean paginable);



}
