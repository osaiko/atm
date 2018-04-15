package com.atm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.atm.entity.User;

import lombok.extern.slf4j.Slf4j;

/**
 * @author oleksii saiko
 *
 * User DAO implementation
 */
@Slf4j
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByPin(int pin) {
        String hql = "FROM User as u WHERE u.pin = :pin";
        User user = null;
        try {
            user = (User) entityManager.createQuery(hql).setParameter("pin", pin).getSingleResult();
        } catch (Exception e) {
            log.debug("Can't get user by pin number. %s", e.getMessage());
        }
        return user;
    }

}
