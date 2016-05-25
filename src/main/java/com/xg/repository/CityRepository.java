package com.xg.repository;

import com.xg.domain.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-24 22:52.
 * @DESCRIPTION:
 */

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Integer> {

}
