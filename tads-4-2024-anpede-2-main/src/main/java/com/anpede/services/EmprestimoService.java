package com.anpede.services;

import com.anpede.entities.Emprestimo;
import com.anpede.repositories.EmprestimoRepository;
import com.anpede.dto.EmprestimoDTO;
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
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    @Transactional(readOnly = true)
    public List<EmprestimoDTO> findAll() {
        List<Emprestimo> list = repository.findAll();
        return list.stream().map(EmprestimoDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmprestimoDTO findById(Long id) {
        Optional<Emprestimo> obj = repository.findById(id);
        Emprestimo entity = obj.orElseThrow(() -> new ResourceNotFoundException("Emprestimo not found"));
        return new EmprestimoDTO(entity);
    }

    @Transactional
    public EmprestimoDTO insert(EmprestimoDTO dto) {
        Emprestimo entity = new Emprestimo();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EmprestimoDTO(entity);
    }

    @Transactional
    public EmprestimoDTO update(Long id, EmprestimoDTO dto) {
        try {
            Emprestimo entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new EmprestimoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Emprestimo not found");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Emprestimo not found");
        }
    }

    private void copyDtoToEntity(EmprestimoDTO dto, Emprestimo entity) {
        entity.setDataRetirada(dto.getDataRetirada());
        entity.setDataDevolucao(dto.getDataDevolucao());
        entity.setMotivo(dto.getMotivo());
        entity.setEquipamento(dto.getEquipamento());
        entity.setAssociado(dto.getAssociado());
    }
}