package com.integracion.crud.conexion.repository;

import com.integracion.crud.conexion.entity.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaestroRepository extends JpaRepository<Maestro, Long> {
}
