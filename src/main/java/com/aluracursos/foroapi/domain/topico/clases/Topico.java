package com.aluracursos.foroapi.domain.topico.clases;

import com.aluracursos.foroapi.domain.topico.dto.DatosActualizarTopico;
import com.aluracursos.foroapi.domain.topico.dto.DatosRegistroTopico;
import com.aluracursos.foroapi.domain.topico.enumeraciones.Curso;
import com.aluracursos.foroapi.domain.topico.enumeraciones.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Estado status;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DatosRegistroTopico datosRequeridosTopico) {
        this.titulo = datosRequeridosTopico.titulo();
        this.mensaje = datosRequeridosTopico.mensaje();
        this.fechaCreacion = datosRequeridosTopico.fecha_creacion();
        this.status = datosRequeridosTopico.status();
        this.autor = datosRequeridosTopico.autor();
        this.curso = datosRequeridosTopico.curso();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        this.titulo = datosActualizarTopico.titulo();
        this.mensaje = datosActualizarTopico.mensaje();
        this.status = datosActualizarTopico.status();
        this.autor = datosActualizarTopico.autor();
        this.curso = datosActualizarTopico.curso();
    }
}
