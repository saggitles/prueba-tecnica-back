package com.example.demo.repositories;

import com.example.demo.models.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresasRepository extends JpaRepository <Empresas, Long> {
}
