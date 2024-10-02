package com.erp.zkteco.service;

import com.erp.zkteco.entity.IclockTransaction;
import com.erp.zkteco.repository.IclockTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IclockTransactionService {

    @Autowired
    private IclockTransactionRepository iclockTransactionRepository;

    // Método para obtener todas las transacciones
    public List<IclockTransaction> getAllTransactions() {
        return iclockTransactionRepository.findAll();
    }

    // Método para obtener una transacción por su ID
    public Optional<IclockTransaction> getTransactionById(Long id) {
        return iclockTransactionRepository.findById(id);
    }

    // Método para obtener transacciones por código de empleado (empCode)
    public List<IclockTransaction> getTransactionsByEmpCode(String empCode) {
        return iclockTransactionRepository.findAll().stream()
                .filter(transaction -> transaction.getEmpCode().equals(empCode))
                .toList();
    }
}
