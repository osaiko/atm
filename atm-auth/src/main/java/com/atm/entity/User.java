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
 * User entity
 */
@Getter
@Setter
@Entity
@Table(name="user")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int userId;
    
    @Column(name="pin")
    private int pin;
    
    @Column(name="name")    
    private String name;
    
    @Column(name="access")    
    private String access;

}
