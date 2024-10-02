package com.erp.zkteco.controller;

import com.erp.zkteco.entity.IclockTransaction;
import com.erp.zkteco.service.IclockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class IclockTransactionController {

    @Autowired
    private IclockTransactionService iclockTransactionService;

    // Endpoint para obtener todas las transacciones
    @GetMapping("/all")
    public ResponseEntity<List<IclockTransaction>> getAllTransactions() {
        List<IclockTransaction> transactions = iclockTransactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    // Endpoint para obtener una transacción por su ID
    @GetMapping("/{id}")
    public ResponseEntity<IclockTransaction> getTransactionById(@PathVariable Long id) {
        Optional<IclockTransaction> transaction = iclockTransactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para obtener transacciones por código de empleado (empCode)
    @GetMapping("/employee/{empCode}")
    public ResponseEntity<List<IclockTransaction>> getTransactionsByEmpCode(@PathVariable String empCode) {
        List<IclockTransaction> transactions = iclockTransactionService.getTransactionsByEmpCode(empCode);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transactions);
    }
}
