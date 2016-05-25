package com.xg.service;

import com.xg.domain.Category;
import com.xg.domain.City;
import com.xg.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-24 22:55.
 * @DESCRIPTION:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CityService {

    @Autowired
    private CityRepository repository;

    public City get(int id) {
        return repository.findOne(id);
    }

    public Page<City> find(String name, Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = false)
    public City add(City city) {
        if (city == null) {
            return null;
        }
        city.setLastUpdate(new Date());
        repository.save(city);
        return city;
    }

    @Transactional(readOnly = false)
    public boolean delete(City city) {
        if (city == null) {
            return false;
        }
        repository.delete(city);
        return true;
    }
    public Page<City> findAll(String name, Pageable pageable) {
        return repository.findAll(pageable);
    }
}
