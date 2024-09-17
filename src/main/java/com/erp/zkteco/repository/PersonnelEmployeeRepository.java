package com.erp.zkteco.repository;

import com.erp.zkteco.entity.PersonnelEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelEmployeeRepository extends JpaRepository<PersonnelEmployee, Long> {
}
