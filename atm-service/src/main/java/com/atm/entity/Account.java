package com.atm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author oleksii saiko
 * 
 * Account entity
 *
 */
@Getter
@Setter
@Entity
@Table(name = "account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int accountId;

    @Column(name = "pin")
    private int pin;

    @Column(name = "balance")
    private float balance;

    @Column(name = "deposit")
    private float deposit;
}
