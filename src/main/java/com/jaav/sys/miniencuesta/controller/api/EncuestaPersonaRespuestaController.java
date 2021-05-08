package com.jaav.sys.miniencuesta.controller.api;

import com.jaav.sys.miniencuesta.model.api.MeEncuestaPersonaRespuestaJson;
import com.jaav.sys.miniencuesta.service.MeEncuestaPersonaRespuestaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
//@CrossOrigin
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/business/miniencuesta/v1/respuesta")
public class EncuestaPersonaRespuestaController {

    private static final Logger logger = LoggerFactory.getLogger(EncuestaPersonaRespuestaController.class);

    @Autowired
    private MeEncuestaPersonaRespuestaService meEncuestaAlternativaService;



    /** ACCIONES */


    @GetMapping(value = "/id/{id}" ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "obtener por id" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = MeEncuestaPersonaRespuestaJson.class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<MeEncuestaPersonaRespuestaJson> obtenerPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<MeEncuestaPersonaRespuestaJson>(
                    meEncuestaAlternativaService.obtenerPorId(id)
                            .orElse(new MeEncuestaPersonaRespuestaJson()), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/" ,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "listar" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = MeEncuestaPersonaRespuestaJson[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<MeEncuestaPersonaRespuestaJson>> obtenerTodos(Pageable pageable){
        try {
            return new ResponseEntity<>(
                    meEncuestaAlternativaService.findAll(), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/tema/{enteCodigo}" ,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "listar por tema" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = MeEncuestaPersonaRespuestaJson[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<MeEncuestaPersonaRespuestaJson>> listarTemaCodigo(
            @PathVariable String enteCodigo){
        try {
            return new ResponseEntity<>(
                    meEncuestaAlternativaService.findByTema(enteCodigo), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/pag/{iniPag}/{sizePag}/tema/{enteCodigo}" ,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "listr por tema y paginado" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = MeEncuestaPersonaRespuestaJson[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<MeEncuestaPersonaRespuestaJson>> listarTemaCodigo(
            @PathVariable(name = "enteCodigo") String enteCodigo,
            @PathVariable(name = "iniPag") Integer iniPag,
            @PathVariable(name = "sizePag") Integer sizePag){
        try {
            /*MeEncuestaPersonaRespuesta filtro = new MeEncuestaPersonaRespuesta();
            MeEncuestaAlternativa altFiltro = new MeEncuestaAlternativa();
            altFiltro.setEnteCodigo(enteCodigo);
            filtro.setMeEncuestaAlternativa(altFiltro);
            filtro.setInicio(iniPag);
            filtro.setNumeroFilas(sizePag);
            List<MeEncuestaPersonaRespuesta> lista = meEncuestaAlternativaService.listar(filtro, true);

            if(Optional.ofNullable(lista).isPresent() && !lista.isEmpty()){
                int cuentaTotal = meEncuestaAlternativaService.contarListado(filtro);
                lista.stream().forEach(c -> {c.setContadorTotal(cuentaTotal);});
            }*/
            return new ResponseEntity<>(
                    meEncuestaAlternativaService.findByTema(enteCodigo), HttpStatus.OK);

        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/usuario/{codUsuario}/tema/{enteCodigo}" ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "listar por usuario y por tema" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = MeEncuestaPersonaRespuestaJson[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<MeEncuestaPersonaRespuestaJson>> obtenerPorCodigoUsuario(
            @PathVariable String codUsuario , @PathVariable String enteCodigo
    ){
        try {

            return new ResponseEntity<>(
                    meEncuestaAlternativaService.findByTemaUsuario(enteCodigo,codUsuario),
                    HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/" ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "guardar" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "POST"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = MeEncuestaPersonaRespuestaJson.class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<MeEncuestaPersonaRespuestaJson> guardar(
            @RequestBody MeEncuestaPersonaRespuestaJson objJson){
        try {
            return new ResponseEntity<MeEncuestaPersonaRespuestaJson>(
                    meEncuestaAlternativaService.save(objJson)
                            .orElseThrow(() -> new Exception("not save")), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/" ,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "actualizar" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "PUT"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = MeEncuestaPersonaRespuestaJson.class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<MeEncuestaPersonaRespuestaJson> actualizar(
            @RequestBody MeEncuestaPersonaRespuestaJson objJson){
        try {
            return new ResponseEntity<MeEncuestaPersonaRespuestaJson>(
                    meEncuestaAlternativaService.update(objJson)
                            .orElseThrow(() -> new Exception("not save")), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}" ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "eliminar" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = Boolean.class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<Boolean> eliminar(
            @PathVariable Long id){
        try {
            return new ResponseEntity<Boolean>(
                    meEncuestaAlternativaService.delete(id) > 0, HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
