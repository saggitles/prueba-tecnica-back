package com.example.demo.repositories;
import com.example.demo.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository <Usuarios, Long> {
    UserDetails findByEmail(String username);
}
