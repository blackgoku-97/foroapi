package com.aluracursos.foroapi.infra.security;

import com.aluracursos.foroapi.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username);
    }

    // Verificar si el usuario existe
    public boolean usuarioExiste(String login) {
        return usuarioRepository.existsByLogin(login);
    }
}
