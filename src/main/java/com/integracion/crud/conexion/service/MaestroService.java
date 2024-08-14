package com.integracion.crud.conexion.service;

import com.integracion.crud.conexion.entity.Maestro;
import com.integracion.crud.conexion.repository.MaestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaestroService {

    private final MaestroRepository maestroRepository;

    @Autowired
    public MaestroService(MaestroRepository maestroRepository) {
        this.maestroRepository = maestroRepository;
    }

    public List<Maestro> getMaestros() {
        return maestroRepository.findAll();
    }

    public Optional<Maestro> getMaestro(Long id) {
        return maestroRepository.findById(id);
    }

    public void save(Maestro maestro) {
        maestroRepository.save(maestro);
    }

    public void delete(Long id) {
        maestroRepository.deleteById(id);
    }
}
