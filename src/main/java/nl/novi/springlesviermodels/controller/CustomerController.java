package nl.novi.springlesviermodels.controller;

import nl.novi.springlesviermodels.domain.dto.CreateCustomerDto;
import nl.novi.springlesviermodels.domain.dto.CustomerCreatedDto;
import nl.novi.springlesviermodels.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("customers")
public class CustomerController {


    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping
    ResponseEntity<CustomerCreatedDto> createCustomer(@RequestBody CreateCustomerDto createCustomerDto){
       final CustomerCreatedDto createdCustomer =  customerService.createCustomer(createCustomerDto);
//       return ResponseEntity.ok(createdCustomer);

       final URI location = URI.create("/customers" + createdCustomer.getId());
       return ResponseEntity
               .created(location)
               .body(createdCustomer);


    }



}
