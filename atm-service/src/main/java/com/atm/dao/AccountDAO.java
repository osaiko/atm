package com.atm.dao;

import com.atm.entity.Account;

/**
 * @author oleksii saiko
 * 
 * Account DAO interface
 *
 */
public interface AccountDAO {
        
    public Account getAccountByPin(int pin);
    
    void updateAccount(Account account);

}
