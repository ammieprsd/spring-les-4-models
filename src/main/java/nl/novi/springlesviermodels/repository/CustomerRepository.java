package nl.novi.springlesviermodels.repository;

import nl.novi.springlesviermodels.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
