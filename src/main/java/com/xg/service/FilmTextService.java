package com.xg.service;

import com.xg.domain.FilmText;
import com.xg.repository.FilmTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 14:54.
 * @DESCRIPTION:
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class FilmTextService {

    @Autowired
    private FilmTextRepository repository;

    public FilmText get(int id) {
        return repository.findOne(id);
    }

    @Transactional(readOnly = false)
    public FilmText add(FilmText entity) {
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
    public boolean delete(FilmText entity) {
        if (entity == null) {
            return false;
        }
        repository.delete(entity);
        return true;
    }

    @Transactional(readOnly = false)
    public FilmText update(FilmText entity) {
        if (entity == null) {
            return null;
        }
        entity.setLastUpdate(new Date());
        repository.save(entity);
        return entity;
    }

}