package com.xg.repository;

import com.xg.domain.FilmText;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 12:19.
 * @DESCRIPTION:
 */

@Repository
public interface FilmTextRepository extends PagingAndSortingRepository<FilmText, Integer> {
}
