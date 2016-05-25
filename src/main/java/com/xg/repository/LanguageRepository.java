package com.xg.repository;

import com.xg.domain.Language;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 12:18.
 * @DESCRIPTION:
 */

@Repository
public interface LanguageRepository extends PagingAndSortingRepository<Language, Integer> {

}