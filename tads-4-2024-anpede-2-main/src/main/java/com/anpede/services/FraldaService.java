package com.anpede.services;

import com.anpede.entities.Fralda;
import com.anpede.repositories.FraldaRepository;
import com.anpede.dto.FraldaDTO;
import com.anpede.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FraldaService {

    @Autowired
    private FraldaRepository repository;

    @Transactional(readOnly = true)
    public List<FraldaDTO> findAll() {
        List<Fralda> list = repository.findAll();
        return list.stream().map(FraldaDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FraldaDTO findById(Long id) {
        Optional<Fralda> obj = repository.findById(id);
        Fralda entity = obj.orElseThrow(() -> new ResourceNotFoundException("Fralda not found"));
        return new FraldaDTO(entity);
    }

    @Transactional
    public FraldaDTO insert(FraldaDTO dto) {
        Fralda entity = new Fralda();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new FraldaDTO(entity);
    }

    @Transactional
    public FraldaDTO update(Long id, FraldaDTO dto) {
        try {
            Fralda entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new FraldaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Fralda not found");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Fralda not found");
        }
    }

    private void copyDtoToEntity(FraldaDTO dto, Fralda entity) {
        entity.setDescricao(dto.getDescricao());
        entity.setQuantidadePacote(dto.getQuantidadePacote());
        entity.setTamanho(dto.getTamanho());
        entity.setGenero(dto.getGenero());
        entity.setIncontinencia(dto.getIncontinencia());
        entity.setPeriodo(dto.getPeriodo());
    }
}
