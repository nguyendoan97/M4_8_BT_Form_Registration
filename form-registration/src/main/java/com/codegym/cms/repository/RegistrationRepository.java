package com.codegym.cms.repository;

import com.codegym.cms.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RegistrationRepository extends PagingAndSortingRepository<User, Long> {
//    Iterable<User> findAllByProvince(Province province);
//
//    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
