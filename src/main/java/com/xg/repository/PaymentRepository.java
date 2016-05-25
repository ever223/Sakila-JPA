package com.xg.repository;

import com.xg.domain.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 12:21.
 * @DESCRIPTION:
 */

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Integer> {
}
