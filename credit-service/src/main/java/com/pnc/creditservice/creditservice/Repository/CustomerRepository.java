package com.pnc.creditservice.creditservice.Repository;

import com.pnc.creditservice.creditservice.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {



}
