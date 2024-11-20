package com.aluracursos.foroapi.controller;

import com.aluracursos.foroapi.domain.topico.clases.Topico;
import com.aluracursos.foroapi.domain.topico.dto.DatosActualizarTopico;
import com.aluracursos.foroapi.domain.topico.dto.DatosDetalleTopico;
import com.aluracursos.foroapi.domain.topico.dto.DatosListadoTopico;
import com.aluracursos.foroapi.domain.topico.dto.DatosRegistroTopico;
import com.aluracursos.foroapi.domain.topico.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private PagedResourcesAssembler<DatosListadoTopico> assembler;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<DatosListadoTopico>>> listadoTopicos(@PageableDefault(size = 3) Pageable paginacion) {
        Page<DatosListadoTopico> topicosPage = topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        PagedModel<EntityModel<DatosListadoTopico>> pagedModel = assembler.toModel(topicosPage);
        return ResponseEntity.ok(pagedModel);
    }

    @PostMapping
    public ResponseEntity<String> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        // Verificar si ya existe un tópico con el mismo título y mensaje
        if (topicoRepository.existsByTituloAndMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje())) {
            return ResponseEntity.badRequest().body("Topico con este titulo y mensaje ya existe");
        }

        Topico topico = new Topico();
        topico.setTitulo(datosRegistroTopico.titulo());
        topico.setMensaje(datosRegistroTopico.mensaje());
        topico.setFechaCreacion(LocalDateTime.now());
        topico.setStatus(datosRegistroTopico.status());
        topico.setAutor(datosRegistroTopico.autor());
        topico.setCurso(datosRegistroTopico.curso());

        topicoRepository.save(topico);
        return ResponseEntity.ok("Topico creado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarTopico(@PathVariable Long id, @Valid @RequestBody DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Topico no encontradp"));

        // Verificar si ya existe un tópico con el mismo título y mensaje (excluyendo el tópico actual)
        if (topicoRepository.existsByTituloAndMensaje(datosActualizarTopico.titulo(), datosActualizarTopico.mensaje())) {
            return ResponseEntity.badRequest().body("Topico con este titulo y mensaje ya existe");
        }

        topico.setTitulo(datosActualizarTopico.titulo());
        topico.setMensaje(datosActualizarTopico.mensaje());
        topico.setStatus(datosActualizarTopico.status());
        topico.setAutor(datosActualizarTopico.autor());
        topico.setCurso(datosActualizarTopico.curso());

        topicoRepository.save(topico);
        return ResponseEntity.ok("Topico actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok("Topico eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerDetalleTopico(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID es requerido");
        }

        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Topico no encontrado"));
        DatosDetalleTopico datosDetalleTopico = new DatosDetalleTopico(topico);
        return ResponseEntity.ok(datosDetalleTopico);
    }
}
