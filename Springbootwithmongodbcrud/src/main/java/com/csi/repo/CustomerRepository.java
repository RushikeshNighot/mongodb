package com.csi.repo;

import com.csi.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends MongoRepository<Customer,Integer> {

    Customer findByCustEmailIdAndCustPassword(String custEmailId, String custPassword);
}
