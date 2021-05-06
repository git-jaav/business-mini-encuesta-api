package com.jaav.sys.miniencuesta.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeEncuestaPersonaRespuestaJson {

    private Long enperEncuestaPersonaId;
    private String enperApellidoMaterno;
    private String enperApellidoNombres;
    private String enperApellidoPaterno;
    private String enperCodigoUsuario;
    private Integer enperEdad;
    private String enperEmail;
    private String enperEstado;
    private Date enperFechaRegistro;
    private String enperLugarTrabajo;
    private String enperNombrecompleto;
    private String enperProfesion;
    private String enperSexo;
    private Integer enaltId;

}
