package com.bank.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.api.Model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
}
