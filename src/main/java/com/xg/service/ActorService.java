package com.xg.service;

import com.xg.domain.Actor;
import com.xg.repository.ActorRepository;
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
 * @DATE: 2016-05-24 19:29.
 * @DESCRIPTION:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ActorService {


    @Autowired
    private ActorRepository actorRepository;

    public Actor get(int id) {
        return actorRepository.findOne(id);
    }

    public Page<Actor> find(String name, Pageable pageable) {
        if (StringUtils.isNotEmpty(name)) {
            return actorRepository.findByFirstNameContainingOrLastNameContainingAllIgnoreCase(name, name, pageable);
        } else {
            return actorRepository.findAll(pageable);
        }
    }
    @Transactional(readOnly = false)
    public Actor add(Actor actor) {
        if (actor == null) {
            return null;
        }
        actor.setLastUpdate(new Date());
        actorRepository.save(actor);
        return actor;
    }

    @Transactional(readOnly = false)
    public boolean delete(Actor actor) {
        if (actor == null) {
            return false;
        }
        actorRepository.delete(actor);
        return true;
    }
}
