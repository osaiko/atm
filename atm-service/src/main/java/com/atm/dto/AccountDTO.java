package com.atm.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author oleksii saiko
 * 
 * Account DTO
 *
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int pin;
    private float balance;
    private float deposit;

}
