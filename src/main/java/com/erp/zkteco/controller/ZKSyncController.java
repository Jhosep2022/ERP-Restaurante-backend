package com.erp.zkteco.controller;


import com.erp.restaurante.dto.ResponseDto;
import com.erp.zkteco.service.ZKSyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zkteco")
public class ZKSyncController {

    private static final Logger logger = LoggerFactory.getLogger(ZKSyncController.class);

    @Autowired
    private ZKSyncService zkSyncService;

    @PostMapping("/sync")
    public ResponseDto<String> syncFromZK() {
        logger.info("Iniciando proceso de sincronización desde ZKTeco.");

        try {
            zkSyncService.syncFromZK();
            logger.info("Sincronización exitosa.");
            return new ResponseDto<>(true, "Synchronization successful", null);
        } catch (Exception e) {
            logger.error("Error durante la sincronización desde ZKTeco: ", e);
            return new ResponseDto<>(false, "Synchronization failed: " + e.getMessage(), null);
        }
    }
}