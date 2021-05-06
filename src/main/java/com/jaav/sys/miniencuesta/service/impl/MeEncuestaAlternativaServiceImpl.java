package com.jaav.sys.miniencuesta.service.impl;

import com.jaav.sys.miniencuesta.model.api.MeEncuestaAlternativaJson;
import com.jaav.sys.miniencuesta.model.entities.MeEncuestaAlternativa;
import com.jaav.sys.miniencuesta.repository.MeEncuestaAlternativaRepository;
import com.jaav.sys.miniencuesta.service.MeEncuestaAlternativaService;
import com.jaav.sys.miniencuesta.utils.Constant;
import com.jaav.sys.miniencuesta.utils.JsonViewAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeEncuestaAlternativaServiceImpl implements MeEncuestaAlternativaService {

    @Autowired
    MeEncuestaAlternativaRepository meEncuestaAlternativaRepository;

    private JsonViewAssembler<MeEncuestaAlternativa, MeEncuestaAlternativaJson> jsonAssemb =
            new JsonViewAssembler<MeEncuestaAlternativa, MeEncuestaAlternativaJson>(MeEncuestaAlternativaJson.class);

    private JsonViewAssembler<MeEncuestaAlternativaJson, MeEncuestaAlternativa> jsonAssembInverso =
            new JsonViewAssembler<MeEncuestaAlternativaJson, MeEncuestaAlternativa>(MeEncuestaAlternativa.class);

    @Override
    public Optional<MeEncuestaAlternativa> obtenerPorId(Integer id) {
        return meEncuestaAlternativaRepository.findById(id);
    }



    @Override
    public List<MeEncuestaAlternativaJson> listarTemaCodigo(String enteCodigo) {
        return jsonAssemb.getJsonList(meEncuestaAlternativaRepository.findByEnteCodigoAndEnaltEstado(
                enteCodigo,Constant.ACTIVO_db));
    }


}
