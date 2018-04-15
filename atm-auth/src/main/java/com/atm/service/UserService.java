package com.atm.service;

import com.atm.dto.UserDTO;

/**
 * @author oleksii saiko
 *
 * User service interface
 */
public interface UserService {

    UserDTO getUserByPin(int pin);

}
