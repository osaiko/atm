package com.atm.dao;

import com.atm.entity.User;

/**
 * @author oleksii saiko
 *
 * User DAO interface
 */
public interface UserDAO {

    User getUserByPin(int pin);

}
