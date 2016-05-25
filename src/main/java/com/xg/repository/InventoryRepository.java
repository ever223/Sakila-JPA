package com.xg.repository;

import com.xg.domain.Inventory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 12:20.
 * @DESCRIPTION:
 */

@Repository
public interface InventoryRepository extends PagingAndSortingRepository<Inventory, Integer> {

}