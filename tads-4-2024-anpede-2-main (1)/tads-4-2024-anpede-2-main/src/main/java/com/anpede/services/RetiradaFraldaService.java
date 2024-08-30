package com.anpede.services;

import com.anpede.entities.RetiradaFralda;
import com.anpede.repositories.RetiradaFraldaRepository;
import com.anpede.dto.RetiradaFraldaDTO;
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
public class RetiradaFraldaService {

    @Autowired
    private RetiradaFraldaRepository repository;

    @Transactional(readOnly = true)
    public List<RetiradaFraldaDTO> findAll() {
        List<RetiradaFralda> list = repository.findAll();
        return list.stream().map(RetiradaFraldaDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RetiradaFraldaDTO findById(Long id) {
        Optional<RetiradaFralda> obj = repository.findById(id);
        RetiradaFralda entity = obj.orElseThrow(() -> new ResourceNotFoundException("RetiradaFralda not found"));
        return new RetiradaFraldaDTO(entity);
    }

    @Transactional
    public RetiradaFraldaDTO insert(RetiradaFraldaDTO dto) {
        RetiradaFralda entity = new RetiradaFralda();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new RetiradaFraldaDTO(entity);
    }

    @Transactional
    public RetiradaFraldaDTO update(Long id, RetiradaFraldaDTO dto) {
        try {
            RetiradaFralda entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new RetiradaFraldaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("RetiradaFralda not found");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("RetiradaFralda not found");
        }
    }

    private void copyDtoToEntity(RetiradaFraldaDTO dto, RetiradaFralda entity) {
        entity.setQuantidade(dto.getQuantidade());
        entity.setDataRetirada(dto.getDataRetirada());
        entity.setFralda(dto.getFralda());
        entity.setAssociado(dto.getAssociado());
    }
}
