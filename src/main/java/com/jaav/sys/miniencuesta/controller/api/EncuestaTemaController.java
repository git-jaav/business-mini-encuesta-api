package com.jaav.sys.miniencuesta.controller.api;

import com.jaav.sys.miniencuesta.model.api.MeEncuestaTemaJson;
import com.jaav.sys.miniencuesta.model.entities.MeEncuestaTema;
import com.jaav.sys.miniencuesta.service.MeEncuestaTemaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author JAAV
 */
@RestController
@RequestMapping("/api/business/miniencuesta/v1/tema")
public class EncuestaTemaController {


    private static final Logger logger = LoggerFactory.getLogger(EncuestaTemaController.class);

    @Autowired
    private MeEncuestaTemaService meEncuestaTemaService;


    @GetMapping(value = "/id/{id}" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "get all data demo" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = MeEncuestaTemaJson.class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<MeEncuestaTemaJson> obtenerPorId(@PathVariable String id){
        try {
            return new ResponseEntity<MeEncuestaTemaJson>(
                    meEncuestaTemaService.obtenerPorId(id)
                            .orElseThrow(() -> new Exception("not found")), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "get all data demo" ,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
            //response = MeEncuestaTema[].class
    )
    @ApiResponses({
            @ApiResponse( code = 200, message = "ok",response = MeEncuestaTemaJson[].class),
            @ApiResponse( code = 400, message = "BAD RQ",response = Exception.class)
    })
    public ResponseEntity<List<MeEncuestaTemaJson>> obtenerTodos(){
        try {
            return new ResponseEntity<>(
                    meEncuestaTemaService.listar(new MeEncuestaTema(), false), HttpStatus.OK);
        }catch(Exception e) {
            logger.error("Error: ",e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
