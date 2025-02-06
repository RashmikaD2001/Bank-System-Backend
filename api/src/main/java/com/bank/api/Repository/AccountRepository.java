package com.bank.api.Repository;

import com.bank.api.Model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer> {

    List<AccountModel> findAccountByUserNIC(String nic);
}
