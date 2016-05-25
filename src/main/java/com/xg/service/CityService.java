package com.xg.service;

import com.xg.domain.Actor;
import com.xg.domain.City;
import com.xg.repository.CityRepository;
import org.apache.commons.lang.StringUtils;
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
    private CityRepository cityRepository;

    public City get(int id) {
        return cityRepository.findOne(id);
    }

    public Page<City> find(String name, Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Transactional(readOnly = false)
    public City add(City city) {
        if (city == null) {
            return null;
        }
        city.setLastUpdate(new Date());
        cityRepository.save(city);
        return city;
    }

    @Transactional(readOnly = false)
    public boolean delete(City city) {
        if (city == null) {
            return false;
        }
        cityRepository.delete(city);
        return true;
    }
}
