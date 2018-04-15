package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atm.dto.AccountDTO;
import com.atm.dto.UserDTO;
import com.atm.service.AtmService;

/**
 * @author oleksii saiko
 *
 * ATM rest controller
 */
@Controller
@RequestMapping("atm")
@CrossOrigin(origins = {"${settings.cors_origin}"})
public class AtmController {

    @Autowired
    AtmService atmService;

    @GetMapping("login/{pin}")
    public ResponseEntity<UserDTO> getUserByPin(@PathVariable("pin") int pin) {

        UserDTO user = atmService.getUserByPin(pin);

        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }

    @GetMapping("account/{pin}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable("pin") int pin) {

        AccountDTO accountDTO = atmService.getAccount(pin);

        return new ResponseEntity<AccountDTO>(accountDTO, HttpStatus.OK);
    }

    @PutMapping("account")
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO) {

        atmService.updateAccount(accountDTO);

        return new ResponseEntity<AccountDTO>(accountDTO, HttpStatus.OK);
    }
}
