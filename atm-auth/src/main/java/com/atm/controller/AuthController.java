package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atm.dto.UserDTO;
import com.atm.service.UserService;

/**
 * @author oleksii saiko
 *
 * ATM auth rest controller
 */
@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping("getUserByPin/{pin}")
    public ResponseEntity<UserDTO> getUserByPin(@PathVariable("pin") int pin) {

        UserDTO user = userService.getUserByPin(pin);

        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }
}
