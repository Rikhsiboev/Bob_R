package com.Bob_R.service.impl;

import com.Bob_R.entity.common.UserPrincipal;
import com.Bob_R.service.SecurityServiceInterface;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceIMP implements SecurityServiceInterface {
    private final UserPrincipal userPrincipal;

    public SecurityServiceIMP(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null; /// logic here get user from DB and convert  to spring object how spring understand by using UserPrincipalClass
    }
}
