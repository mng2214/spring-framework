package com.inc.repository;

import com.inc.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // method -> sql == derive query findById(int id);

    //sql  @Query -> pure sql query

    //JPQL @Query -> java persistence ql
    

}
