package nl.novi.springlesviermodels.service;

import nl.novi.springlesviermodels.domain.dto.CreateCustomerDto;
import nl.novi.springlesviermodels.domain.dto.CustomerCreatedDto;
import nl.novi.springlesviermodels.domain.entity.Customer;
import nl.novi.springlesviermodels.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerCreatedDto createCustomer(CreateCustomerDto createCustomerDto) {


        final Customer newCustomer = new Customer();
        newCustomer.setName(createCustomerDto.getUsername());
        newCustomer.setPassword(createCustomerDto.getPassword());

        final Customer savedCustomer = customerRepository.save(newCustomer);

        final CustomerCreatedDto customerCreatedDto = new CustomerCreatedDto();
        customerCreatedDto.setId(savedCustomer.getId());
        customerCreatedDto.setUsername(savedCustomer.getName());

        return customerCreatedDto;
    }
}
