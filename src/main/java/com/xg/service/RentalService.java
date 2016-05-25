package com.xg.service;

import com.xg.domain.Rental;
import com.xg.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 14:52.
 * @DESCRIPTION:
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class RentalService {

    @Autowired
    private RentalRepository repository;

    public Rental get(int id) {
        return repository.findOne(id);
    }

    @Transactional(readOnly = false)
    public Rental add(Rental entity) {
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
    public boolean delete(Rental entity) {
        if (entity == null) {
            return false;
        }
        repository.delete(entity);
        return true;
    }

    @Transactional(readOnly = false)
    public Rental update(Rental entity) {
        if (entity == null) {
            return null;
        }
        entity.setLastUpdate(new Date());
        repository.save(entity);
        return entity;
    }

}