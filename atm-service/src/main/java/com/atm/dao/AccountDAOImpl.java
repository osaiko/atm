package com.atm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atm.entity.Account;

import lombok.extern.slf4j.Slf4j;

/**
 * @author oleksii saiko
 * 
 * Account DAO implementation
 *
 */
@Slf4j
@Repository
public class AccountDAOImpl implements AccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account getAccountByPin(int pin) {

        String hql = "FROM Account as a WHERE a.pin = :pin";
        Account account = null;
        try {
            account = (Account) entityManager.createQuery(hql).setParameter("pin", pin).getSingleResult();
        } catch (Exception e) {
            log.debug("Can't get account by pin number. %s", e.getMessage());
        }
        return account;
    }

    @Transactional
    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }
}
