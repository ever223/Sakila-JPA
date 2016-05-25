package com.xg.service;

import com.xg.domain.Category;
import com.xg.domain.Country;
import com.xg.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-24 22:57.
 * @DESCRIPTION:
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CountryService {
    @Autowired
    private CountryRepository repository;

    public Country get(int id) {
        return repository.findOne(id);
    }

    public Page<Country> find(String name, Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = false)
    public Country add(Country country) {

        if (country == null) {
            return null;
        }

        country.setLastUpdate(new Date());
        repository.save(country);

        return country;
    }

    @Transactional(readOnly = false)
    public boolean delete(Country city) {
        if (city == null) {
            return false;
        }
        repository.delete(city);
        return true;
    }

    @Transactional(readOnly = false)
    public Country update(Country entity) {
        if (entity == null) {
            return null;
        }
        entity.setLastUpdate(new Date());
        repository.save(entity);
        return entity;
    }

    public Page<Country> findAll(String name, Pageable pageable) {
        return repository.findAll(pageable);
    }
}
