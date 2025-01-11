package com.aluracursos.foroapi.controller;

import com.aluracursos.foroapi.domain.usuario.clases.Usuario;
import com.aluracursos.foroapi.domain.usuario.dto.*;
import com.aluracursos.foroapi.domain.usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PagedResourcesAssembler<DatosListadoUsuario> assembler;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<DatosListadoUsuario>>> listadoUsuarios(@PageableDefault(size = 1) Pageable paginacion) {
        Page<DatosListadoUsuario> usuariosPage = usuarioRepository.findAll(paginacion).map(DatosListadoUsuario::new);
        PagedModel<EntityModel<DatosListadoUsuario>> pagedModel = assembler.toModel(usuariosPage);
        return ResponseEntity.ok(pagedModel);
    }

    @PostMapping
    public ResponseEntity<String> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        // Verificar si ya existe un usuario con el mismo login
        if (usuarioRepository.existsByLogin(datosRegistroUsuario.login())) {
            return ResponseEntity.badRequest().body("Usuario con este login ya existe");
        }

        Usuario usuario = new Usuario();
        usuario.setLogin(datosRegistroUsuario.login());
        usuario.setClave(passwordEncoder.encode(datosRegistroUsuario.clave()));

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontradp"));

        // Verificar si ya existe un usuario con el mismo login (excluyendo el usuario actual)
        if (usuarioRepository.existsByLogin(datosActualizarUsuario.login())) {
            return ResponseEntity.badRequest().body("Usuario con este login ya existe");
        }

        usuario.setLogin(datosActualizarUsuario.login());
        usuario.setClave(passwordEncoder.encode(datosActualizarUsuario.clave()));

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerDetalleUsuario(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID es requerido");
        }

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        DatosDetalleUsuario datosDetalleUsuario = new DatosDetalleUsuario(usuario);
        return ResponseEntity.ok(datosDetalleUsuario);
    }
}
