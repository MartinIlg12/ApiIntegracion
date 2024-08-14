package com.integracion.crud.conexion.service;

import com.integracion.crud.conexion.entity.Nota;
import com.integracion.crud.conexion.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    @Autowired
    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public List<Nota> getNotas() {
        return notaRepository.findAll();
    }

    public Optional<Nota> getNota(Long id) {
        return notaRepository.findById(id);
    }

    public void saveOrUpdate(Nota nota) {
        notaRepository.save(nota);
    }

    public void delete(Long id) {
        notaRepository.deleteById(id);
    }
}
