package com.csi.controller;


import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import com.csi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerServiceimpl;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerServiceimpl.signUp(customer), HttpStatus.CREATED);

    }

    @GetMapping("/signin/{email}/{password}")
    public ResponseEntity<Boolean> signIn(@PathVariable String email, @PathVariable String password) {
        return  new ResponseEntity<>(customerServiceimpl.signIn(email,password),HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return new ResponseEntity<>(customerServiceimpl.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findbyid/{custid}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable int custid) {
        return  new ResponseEntity<>(customerServiceimpl.findById(custid),HttpStatus.OK);
    }

    @PutMapping("/updatedata/{custid}")
    public ResponseEntity<Optional<Customer>> updateData(@PathVariable int custid, @RequestBody Customer customer) {
        Customer customer1=customerServiceimpl.findById(custid).orElseThrow(()->new RecordNotFoundException("CUSTOMER ID DOES NOT EXITS"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContNumber(customer.getCustContNumber());
        customer1.setCustAcctBalance(customer.getCustAcctBalance());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());

       return new ResponseEntity( customerServiceimpl.updateAll(customer1),HttpStatus.CREATED);
    }

    @DeleteMapping("/Deletbyid/{custid}")
    public ResponseEntity<String> deleteById(@PathVariable int custid) {
     customerServiceimpl.deleteById(custid);
     return new ResponseEntity<>(" Message Deleted",HttpStatus.OK);
    }

}
