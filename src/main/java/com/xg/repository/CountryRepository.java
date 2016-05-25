package com.xg.repository;

import com.xg.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-24 22:53.
 * @DESCRIPTION:
 */

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {
}
