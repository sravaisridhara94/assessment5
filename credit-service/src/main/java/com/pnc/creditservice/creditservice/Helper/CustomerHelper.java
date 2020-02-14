package com.pnc.creditservice.creditservice.Helper;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pnc.creditservice.creditservice.API.CustomerModel;
import com.pnc.creditservice.creditservice.Domain.Customer;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerHelper {

    public static Long encodeSsn(String ssn){
        Base64 base64 = new Base64();
        String encodedString = new String(base64.encode(ssn.getBytes()));
        return Long.parseLong(encodedString);
    }

    public static CustomerModel toModel(Customer customer){
        CustomerModel model = new CustomerModel();
        model.setCreditCardNo(customer.getCreditCardNo());
        model.setCustomerId(customer.getCustomerId());
        model.setFirstName(customer.getFirstName());
        model.setLastName(customer.getLastName());
        model.setZipCode(customer.getZipCode());
        model.setSsn(customer.getSsn().replace("/0","*"));
        return model;
    }

    public static Customer toObject(CustomerModel model){
        Customer customer = new Customer();
        customer.setCreditCardNo(model.getCreditCardNo());
        customer.setCustomerId(model.getCustomerId());
        customer.setFirstName(model.getFirstName());
        customer.setLastName(model.getLastName());
        customer.setZipCode(model.getZipCode());
        customer.setSsn(model.getSsn());
        return customer;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String approvalCheck(long ssn){
        RestTemplate template = new RestTemplate();
        String url = "localhost:9084/ssn/verify/"+ssn;
        String status = template.getForObject(
                url, String.class);
        return status;
    }

    public String reliable(long ssn){
        return "Yes";
    }


}
