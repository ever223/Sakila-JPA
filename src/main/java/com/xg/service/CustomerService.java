package com.xg.service;

import com.xg.domain.Customer;
import com.xg.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 14:33.
 * @DESCRIPTION:
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer get(int id) {
        return repository.findOne(id);
    }

    @Transactional(readOnly = false)
    public Customer add(Customer entity) {
        if (entity == null) {
            return null;
        }
        entity.setLastUpdate(new Date());
        repository.save(entity);
        return entity;
    }

    @Transactional(readOnly = false)
    public boolean delete(int id) {
        repository.delete(id);
        return true;
    }

    @Transactional(readOnly = false)
    public boolean delete(Customer entity) {
        if (entity == null) {
            return false;
        }
        repository.delete(entity);
        return true;
    }

    @Transactional(readOnly = false)
    public Customer update(Customer entity) {
        if (entity == null) {
            return null;
        }
        entity.setLastUpdate(new Date());
        repository.save(entity);
        return entity;
    }

}