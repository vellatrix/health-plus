package org.healthplus.repository;

import org.healthplus.entity.Customer;
import org.healthplus.repository.impl.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
}
