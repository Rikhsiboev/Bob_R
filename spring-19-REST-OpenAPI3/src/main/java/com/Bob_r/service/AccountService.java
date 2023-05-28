package com.Bob_r.service;

import com.Bob_r.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> getAccounts();

    AccountDTO getById(Long id) throws Exception;

}
