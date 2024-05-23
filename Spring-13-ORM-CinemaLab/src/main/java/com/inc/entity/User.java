package com.inc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_account")
public class User extends BaseEntity {

    private String email;
    private String password;
    private String username;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    private Account account;
}
