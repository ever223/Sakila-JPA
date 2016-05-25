package com.xg.repository;

import com.xg.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 12:19.
 * @DESCRIPTION:
 */

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

}