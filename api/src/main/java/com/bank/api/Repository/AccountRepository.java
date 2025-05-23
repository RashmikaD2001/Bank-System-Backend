package com.bank.api.Repository;

import com.bank.api.Model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer> {

    List<AccountModel> findAccountByUserNic(String nic);

    // Find account not active
    List<AccountModel> findByIsAccountActiveFalse();

    // Find account active
    List<AccountModel> findByIsAccountActiveTrue();
}
