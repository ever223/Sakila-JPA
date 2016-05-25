package com.xg.repository;

import com.xg.domain.Film;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-24 23:44.
 * @DESCRIPTION:
 */

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {
}
