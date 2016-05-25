package com.xg.service;

import com.xg.domain.Inventory;
import com.xg.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 14:36.
 * @DESCRIPTION:
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public Inventory get(int id) {
        return repository.findOne(id);
    }

    @Transactional(readOnly = false)
    public Inventory add(Inventory entity) {
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
    public boolean delete(Inventory entity) {
        if (entity == null) {
            return false;
        }
        repository.delete(entity);
        return true;
    }

    @Transactional(readOnly = false)
    public Inventory update(Inventory entity) {
        if (entity == null) {
            return null;
        }
        entity.setLastUpdate(new Date());
        repository.save(entity);
        return entity;
    }

}