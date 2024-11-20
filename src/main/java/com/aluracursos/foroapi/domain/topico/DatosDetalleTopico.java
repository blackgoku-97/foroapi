package com.aluracursos.foroapi.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Estado status,
        String autor,
        Curso curso
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}

