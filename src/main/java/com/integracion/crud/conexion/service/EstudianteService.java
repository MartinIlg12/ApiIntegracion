package com.integracion.crud.conexion.service;

import com.integracion.crud.conexion.entity.Estudiante;
import com.integracion.crud.conexion.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;
    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional <Estudiante> getEstudiante(Long id) {
        return estudianteRepository.findById(id);
    }

    public void saveOrUpdate(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public void delete(Long id) {
        estudianteRepository.deleteById(id);
    }
}
