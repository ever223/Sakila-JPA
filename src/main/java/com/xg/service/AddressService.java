package com.xg.service;

import com.xg.domain.Address;
import com.xg.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 13:58.
 * @DESCRIPTION:
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Address get(int id) {
        return repository.findOne(id);
    }

    @Transactional(readOnly = false)
    public Address add(Address entity) {
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
    public boolean delete(Address entity) {
        if (entity == null) {
            return false;
        }
        repository.delete(entity);
        return true;
    }

    @Transactional(readOnly = false)
    public Address update(Address entity) {
        if (entity == null) {
            return null;
        }
        entity.setLastUpdate(new Date());
        repository.save(entity);
        return entity;
    }

}
