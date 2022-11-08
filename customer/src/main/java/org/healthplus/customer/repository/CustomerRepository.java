package org.healthplus.customer.repository;

import org.healthplus.customer.entity.Customer;
import org.healthplus.customer.repository.impl.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {


}
