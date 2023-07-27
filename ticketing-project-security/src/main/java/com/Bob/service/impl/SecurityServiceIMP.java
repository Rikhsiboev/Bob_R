package com.Bob.service.impl;

import com.Bob.entity.User;
import com.Bob.entity.common.UserPrincipal;
import com.Bob.repository.UserRepository;
import com.Bob.service.SecurityServiceInterface;
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
