package com.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atm.dao.AccountDAO;
import com.atm.dto.AccountDTO;
import com.atm.dto.UserDTO;
import com.atm.entity.Account;

import lombok.extern.slf4j.Slf4j;

/**
 * @author oleksii saiko
 * 
 * ATM service implementation
 *
 */
@Slf4j
@Service
public class AtmServiceImpl implements AtmService {

    @Autowired
    AccountDAO accountDAO;

    @Value("${auth.server.path}")
    String authUrl;

    @Override
    public UserDTO getUserByPin(int pin) {

        RestTemplate restTemplate = new RestTemplate();

        UserDTO user = new UserDTO();

        try {
            user = restTemplate.getForObject(authUrl + "/" + pin, UserDTO.class);
        } catch (Exception e) {
            log.debug("Can't access auth server. %s", e.getMessage());
        }
        return user;
    }

    @Override
    public AccountDTO getAccount(int pin) {

        AccountDTO accountDTO = new AccountDTO();

        Account account = accountDAO.getAccountByPin(pin);

        if (account != null) {
            accountDTO.setId(account.getAccountId());
            accountDTO.setPin(account.getPin());
            accountDTO.setBalance(account.getBalance());
            accountDTO.setDeposit(account.getDeposit());
        }
        return accountDTO;
    }

    @Override
    public void updateAccount(AccountDTO accountDTO) {

        Account account = new Account();

        account.setAccountId(accountDTO.getId());
        account.setBalance(accountDTO.getBalance());
        account.setDeposit(accountDTO.getDeposit());
        account.setPin(accountDTO.getPin());

        accountDAO.updateAccount(account);

    }
}
