package com.jaav.sys.miniencuesta.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="me_encuesta_alternativa")
public class MeEncuestaAlternativa {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="enalt_id")
    private Integer enaltId;

    @Column(name="enalt_estado")
    private String enaltEstado;

    @Column(name="enalt_opcion")
    private String enaltOpcion;

    @Column(name="ente_codigo")
    private String enteCodigo;

    //bi-directional many-to-one association to MeEncuestaTema
    @ManyToOne
    @JoinColumn(name="ente_codigo", insertable = false, updatable = false)
    private MeEncuestaTema meEncuestaTema;

}
