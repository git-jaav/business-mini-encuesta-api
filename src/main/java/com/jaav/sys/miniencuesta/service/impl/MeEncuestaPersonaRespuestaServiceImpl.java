package com.jaav.sys.miniencuesta.service.impl;

import com.jaav.sys.miniencuesta.model.api.MeEncuestaPersonaRespuestaJson;
import com.jaav.sys.miniencuesta.model.entities.MeEncuestaPersonaRespuesta;
import com.jaav.sys.miniencuesta.repository.MeEncuestaPersonaRespuestaRepository;
import com.jaav.sys.miniencuesta.service.MeEncuestaPersonaRespuestaService;
import com.jaav.sys.miniencuesta.utils.JsonViewAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeEncuestaPersonaRespuestaServiceImpl implements MeEncuestaPersonaRespuestaService {


    @Autowired
    MeEncuestaPersonaRespuestaRepository encuestaPersonaRespuestaRepository;

    private JsonViewAssembler<MeEncuestaPersonaRespuesta, MeEncuestaPersonaRespuestaJson> jsonAssemb =
            new JsonViewAssembler<MeEncuestaPersonaRespuesta, MeEncuestaPersonaRespuestaJson>(MeEncuestaPersonaRespuestaJson.class);

    private JsonViewAssembler<MeEncuestaPersonaRespuestaJson, MeEncuestaPersonaRespuesta> jsonAssembInverso =
            new JsonViewAssembler<MeEncuestaPersonaRespuestaJson, MeEncuestaPersonaRespuesta>(MeEncuestaPersonaRespuesta.class);

    @Override
    public Optional<MeEncuestaPersonaRespuestaJson> obtenerPorId(Long id) {
        return encuestaPersonaRespuestaRepository.findById(id)
                .map(e -> jsonAssemb.getJsonObject(e));
    }

    @Override
    public int contarListado(MeEncuestaPersonaRespuesta objDao) {
        return 0;
    }

    @Override
    public List<MeEncuestaPersonaRespuestaJson> findAll() {
        List<MeEncuestaPersonaRespuesta> list = new ArrayList<>();
        encuestaPersonaRespuestaRepository.findAll().iterator()
                .forEachRemaining(list::add);
        return jsonAssemb.getJsonList(list);
    }


    @Override
    public List<MeEncuestaPersonaRespuestaJson> findByTema(String tema) {
        return jsonAssemb.getJsonList(encuestaPersonaRespuestaRepository.findByEnteCodigo(tema));
    }

    @Override
    public List<MeEncuestaPersonaRespuestaJson> findByTemaUsuario(String tema, String usuario) {
        return jsonAssemb.getJsonList(encuestaPersonaRespuestaRepository.findByEnteCodigoAndUser(tema,usuario));
    }


    @Override
    public Optional<MeEncuestaPersonaRespuestaJson> save(MeEncuestaPersonaRespuestaJson objDao){
        return Optional.ofNullable(encuestaPersonaRespuestaRepository.save(
                jsonAssembInverso.getJsonObject(objDao)))
                .map(e -> jsonAssemb.getJsonObject(e));
    }

    @Override
    public Optional<MeEncuestaPersonaRespuestaJson> update(MeEncuestaPersonaRespuestaJson objDao) {
        return Optional.ofNullable(encuestaPersonaRespuestaRepository.save(
                jsonAssembInverso.getJsonObject(objDao)))
                .map(e -> jsonAssemb.getJsonObject(e));
    }

    @Override
    public int delete(Long id) throws Exception{
        return encuestaPersonaRespuestaRepository.findById(id)
                .map(e -> {
                    encuestaPersonaRespuestaRepository.delete(e);
                    return 1;
                }).orElseThrow(() -> new Exception("not delteted"));
    }
}
