package com.xg.repository;

import com.xg.domain.Staff;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 12:22.
 * @DESCRIPTION:
 */

@Repository
public interface StaffRepository extends PagingAndSortingRepository<Staff, Integer> {

}