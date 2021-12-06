package com.example.jpa_programming.services;

import com.example.jpa_programming.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public  long insert(User user){
        //open transaction
        entityManager.persist(user);
        //ended transaction
        return user.getId();
    }
}
