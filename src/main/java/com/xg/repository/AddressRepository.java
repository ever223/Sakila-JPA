package com.xg.repository;

import com.xg.domain.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 12:12.
 * @DESCRIPTION:
 */

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Integer> {
}
