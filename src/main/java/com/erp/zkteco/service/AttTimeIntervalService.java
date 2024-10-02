package com.erp.zkteco.service;

import com.erp.zkteco.entity.AttTimeInterval;
import com.erp.zkteco.repository.AttTimeIntervalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttTimeIntervalService {

    @Autowired
    private AttTimeIntervalRepository attTimeIntervalRepository;

    // Método para obtener todos los registros de AttTimeInterval
    public List<AttTimeInterval> getAllTimeIntervals() {
        return attTimeIntervalRepository.findAll();
    }

    // Método para obtener un AttTimeInterval por su ID
    public Optional<AttTimeInterval> getTimeIntervalById(Long id) {  // Cambiado a Long
        return attTimeIntervalRepository.findById(id);
    }

    // Método para obtener AttTimeInterval por alias
    public List<AttTimeInterval> getTimeIntervalsByAlias(String alias) {
        return attTimeIntervalRepository.findByAlias(alias);
    }

    // Método para obtener AttTimeInterval por companyId
    public List<AttTimeInterval> getTimeIntervalsByCompanyId(Long companyId) {  // Cambiado a Long
        return attTimeIntervalRepository.findByCompanyId(companyId);
    }

    // Método para crear un nuevo AttTimeInterval (POST)
    public AttTimeInterval createTimeInterval(AttTimeInterval timeInterval) {
        return attTimeIntervalRepository.save(timeInterval);
    }

    // Método para actualizar un AttTimeInterval existente (PUT)
    public Optional<AttTimeInterval> updateTimeInterval(Long id, AttTimeInterval updatedTimeInterval) {  // Cambiado a Long
        return attTimeIntervalRepository.findById(id).map(existingTimeInterval -> {
            existingTimeInterval.setAlias(updatedTimeInterval.getAlias());
            existingTimeInterval.setUseMode(updatedTimeInterval.getUseMode());
            // Actualiza otros campos según sea necesario
            return attTimeIntervalRepository.save(existingTimeInterval);
        });
    }

    // Método para eliminar un AttTimeInterval por su ID
    public void deleteTimeInterval(Long id) {  // Cambiado a Long
        attTimeIntervalRepository.deleteById(id);
    }
}
