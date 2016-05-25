package com.xg.repository;

import com.xg.domain.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-24 19:28.
 * @DESCRIPTION:
 */


@Repository
public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer> {
    Page<Actor> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(String firstName, String lastName, Pageable pageable);
}
