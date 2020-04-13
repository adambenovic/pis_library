package pis_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pis_library.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
