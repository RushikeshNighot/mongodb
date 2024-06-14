package com.csi.service;

import com.csi.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Customer signUp(Customer customer);

    boolean signIn(String custEmailId, String custPassword);

    List<Customer> findAll();

    Optional<Customer> findById(int  custId);

    Customer updateAll(Customer customer);

    void deleteById(int  custId);
}
