package com.Bob_R.service.impl;

import com.Bob_R.entity.User;
import com.Bob_R.entity.common.UserPrincipal;
import com.Bob_R.repository.UserRepository;
import com.Bob_R.service.SecurityServiceInterface;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceIMP implements SecurityServiceInterface {
    private final UserRepository userRepository;

    public SecurityServiceIMP(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameAndIsDeleted(username,false);

        if (user == null){
            throw new UsernameNotFoundException(username);
        }


        return new UserPrincipal(user); /// logic here get user from DB and convert  to spring object how spring understand by using UserPrincipalClass
    }
}
