package com.Bob_r.dto;

import com.Bob_r.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // mean that know field just skip what i have
public class UserDTO {
    @JsonIgnoreProperties
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // not showing in jason
    private String password;
    private String username;
    private UserRole role;

    @JsonManagedReference  // This field is going to be serialized wew can see
    private AccountDTO account;

}
