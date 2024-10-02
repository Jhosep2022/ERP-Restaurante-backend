package com.erp.zkteco.repository;

import com.erp.zkteco.entity.IclockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IclockTransactionRepository extends JpaRepository<IclockTransaction, Long> {

}
