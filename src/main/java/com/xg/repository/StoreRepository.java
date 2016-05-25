package com.xg.repository;

import com.xg.domain.Store;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 12:23.
 * @DESCRIPTION:
 */

@Repository
public interface StoreRepository extends PagingAndSortingRepository<Store, Integer> {

}