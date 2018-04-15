package com.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.dao.UserDAO;
import com.atm.dto.UserDTO;
import com.atm.entity.User;

/**
 * @author oleksii saiko
 *
 * User service implementation
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDTO getUserByPin(int pin) {

        UserDTO userDTO = new UserDTO();

        User user = userDAO.getUserByPin(pin);

        if (user != null) {

            userDTO.setPin(user.getPin());
            userDTO.setName(user.getName());
            userDTO.setAccess(user.getAccess());
        }

        return userDTO;
    }

}
