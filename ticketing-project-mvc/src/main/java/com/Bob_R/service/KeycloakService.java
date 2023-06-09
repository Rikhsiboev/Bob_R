package com.Bob_R.service;

import com.Bob_R.dto.UserDTO;
import org.keycloak.adapters.spi.HttpFacade;

import javax.ws.rs.core.Response;

public interface KeycloakService {
    Response userCreate(UserDTO dto);
    void delete(String username);
}
