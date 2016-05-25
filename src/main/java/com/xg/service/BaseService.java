package com.xg.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 13:23.
 * @DESCRIPTION:
 */

public interface BaseService<T> {

    T get(int id);

    T add(T entity);

    boolean delete(int id);

    boolean delete(T entity);

    T update(T entity);

   // Page<T> findAll(Pageable pageable, Object... Objects);
}
