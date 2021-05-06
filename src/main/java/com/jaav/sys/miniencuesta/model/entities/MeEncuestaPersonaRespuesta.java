package com.jaav.sys.miniencuesta.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="me_encuesta_persona_respuesta")
public class MeEncuestaPersonaRespuesta extends  EntidadSup {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="enper_encuesta_persona_id")
    private Long enperEncuestaPersonaId;

    @Column(name="enper_apellido_materno")
    private String enperApellidoMaterno;

    @Column(name="enper_apellido_nombres")
    private String enperApellidoNombres;

    @Column(name="enper_apellido_paterno")
    private String enperApellidoPaterno;

    @Column(name="enper_codigo_usuario")
    private String enperCodigoUsuario;

    @Column(name="enper_edad")
    private Integer enperEdad;

    @Column(name="enper_email")
    private String enperEmail;

    @Column(name="enper_estado")
    private String enperEstado;

    @Column(name="enper_fecha_registro")
    private Date enperFechaRegistro;

    @Column(name="enper_lugar_trabajo")
    private String enperLugarTrabajo;

    @Column(name="enper_nombrecompleto")
    private String enperNombrecompleto;

    @Column(name="enper_profesion")
    private String enperProfesion;

    @Column(name="enper_sexo")
    private String enperSexo;

    @Column(name="enalt_id")
    private Integer enaltId;

    //bi-directional many-to-one association to MeEncuestaAlternativa
    @ManyToOne
    @JoinColumn(name="enalt_id", insertable=false, updatable = false)
    private MeEncuestaAlternativa meEncuestaAlternativa;
}
