package com.xg.repository;

import com.xg.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 12:13.
 * @DESCRIPTION:
 */

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

}
