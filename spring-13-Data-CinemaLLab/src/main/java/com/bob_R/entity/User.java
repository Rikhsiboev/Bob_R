package com.bob_R.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_account")
public class User extends BaseEntity{
    private String email;
    private String password;
    private String username;

    @OneToOne (fetch = FetchType.LAZY) // do not bring object when load
    @JoinColumn(name = "account_Details_id")
    private Account account;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
