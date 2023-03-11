package com.Bob_R.entity;

import com.Bob_R.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User extends BaseEntity {
    private String fistName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean enable;
    private Role role;
    private Gender gender;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserid, String fistName, String lastName, String userName, String passWord, boolean enable, Role role, Gender gender) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserid);
        this.fistName = fistName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.enable = enable;
        this.role = role;
        this.gender = gender;
    }
}
