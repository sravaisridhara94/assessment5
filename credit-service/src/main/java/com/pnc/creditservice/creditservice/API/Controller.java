package com.pnc.creditservice.creditservice.API;

import com.pnc.creditservice.creditservice.Domain.Customer;
import com.pnc.creditservice.creditservice.Helper.CustomerHelper;
import com.pnc.creditservice.creditservice.Service.CustomerService;
import io.swagger.annotations.Api;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/Customer")
public class Controller {

    private CustomerService service;

    private CustomerHelper helper;

    public Controller(CustomerService service, CustomerHelper helper) {
        this.service = service;
        this.helper = helper;
    }

    private Log logger = LogFactory.getLog(Controller.class);

    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerModel> create(@RequestBody CustomerModel model) {
        try {
            Customer customer = CustomerHelper.toObject(model);
            Customer savedCustomer = service.saveCustomer(customer);
            return ResponseEntity.created(URI.create("/customers/" + savedCustomer.getCustomerId()))
                    .body(CustomerHelper.toModel(savedCustomer));
        }catch (Exception e){
            logger.error("Error saving customer Object: ",e);
            return null;
        }
    }

    @GetMapping("/isApproved/{customerId}")
    public ResponseEntity<String> isApproved(@PathVariable long customerId){
        try {
            Optional<Customer> customer = service.getCustomerById(customerId);
            String status = helper.approvalCheck(CustomerHelper.encodeSsn(customer.get().getSsn()));
            return ResponseEntity.ok().body(status);
        }catch (Exception e){
            logger.error("Error while connecting to credit score approval service: ",e);
            return null;
        }

    }

}
