package com.xg.service;

import com.xg.domain.Film;
import com.xg.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-24 23:45.
 * @DESCRIPTION:
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public Film get(int id) {
        return filmRepository.findOne(id);
    }

    public Page<Film> find(String name, Pageable pageable) {
        return filmRepository.findAll(pageable);
    }
    @Transactional(readOnly = false)
    public Film add(Film film) {
        if (film == null) {
            return null;
        }
        film.setLastUpdate(new Date());
        filmRepository.save(film);
        return film;
    }

    @Transactional(readOnly = false)
    public boolean delete(Film film) {
        if (film == null) {
            return false;
        }
        filmRepository.delete(film);
        return true;
    }
}
