package com.jaav.sys.miniencuesta.service.impl;

import com.jaav.sys.miniencuesta.model.api.MeEncuestaTemaJson;
import com.jaav.sys.miniencuesta.model.entities.MeEncuestaTema;
import com.jaav.sys.miniencuesta.repository.MeEncuestaTemaRepository;
import com.jaav.sys.miniencuesta.service.MeEncuestaTemaService;
import com.jaav.sys.miniencuesta.utils.JsonViewAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MeEncuestaTemaServiceImpl implements MeEncuestaTemaService {

    @Autowired
    MeEncuestaTemaRepository encuestaTemaRepository;



    private JsonViewAssembler<MeEncuestaTema, MeEncuestaTemaJson> jsonAssemb =
            new JsonViewAssembler<MeEncuestaTema, MeEncuestaTemaJson>(MeEncuestaTemaJson.class);

    private JsonViewAssembler<MeEncuestaTemaJson, MeEncuestaTema> jsonAssembInverso =
            new JsonViewAssembler<MeEncuestaTemaJson, MeEncuestaTema>(MeEncuestaTema.class);

    //@Override
    public Optional<List<MeEncuestaTema>> getAllElements() {
        return Optional.ofNullable(encuestaTemaRepository.findAll()).map(e -> {
            return StreamSupport.stream(encuestaTemaRepository.findAll()
                    .spliterator(), false)
                    .collect(Collectors.toList());
            }
        );
    }

    @Override
    public Optional<MeEncuestaTemaJson> obtenerPorId(String id) {
        return encuestaTemaRepository.findById(id)
                .map(e -> jsonAssemb.getJsonObject(e));
    }

    @Override
    public List<MeEncuestaTemaJson> listar(MeEncuestaTema objDao, boolean paginable) {
        return StreamSupport.stream(encuestaTemaRepository.findAll()
                .spliterator(), false).map(e -> jsonAssemb.getJsonObject(e))
                .collect(Collectors.toList());
    }
}
