package com.atm.service;

import com.atm.dto.AccountDTO;
import com.atm.dto.UserDTO;

/**
 * @author oleksii saiko
 * 
 * ATM service interface
 *
 */
public interface AtmService {

    UserDTO getUserByPin(int pin);

    AccountDTO getAccount(int pin);

    public void updateAccount(AccountDTO accountDTO);

}
