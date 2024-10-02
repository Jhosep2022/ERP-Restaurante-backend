package com.erp.zkteco.repository;

import com.erp.zkteco.entity.AttTimeInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttTimeIntervalRepository extends JpaRepository<AttTimeInterval, Long> {

    // Método para buscar por alias
    List<AttTimeInterval> findByAlias(String alias);

    // Método para buscar por companyId
    List<AttTimeInterval> findByCompanyId(Long companyId);

}
