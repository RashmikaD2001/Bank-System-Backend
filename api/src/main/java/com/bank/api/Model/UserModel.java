package com.bank.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserModel {

    @Id
    private String nic;
    private String fname;
    private String lname;
    private String email;
    private String telNo;
}
