package com.jaav.sys.miniencuesta.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeEncuestaTemaJson {

    private String enteCodigo;
    private String enteDetalles;
    private String enteEstado;
    private String enteTema;

}
