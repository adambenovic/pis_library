package pis_library;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pis_library.entity.Address;
import pis_library.entity.Fee;
import pis_library.entity.Reader;
import pis_library.repository.AddressRepository;
import pis_library.repository.FeeRepository;
import pis_library.repository.ReaderRepository;
import java.util.Date;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(
            ReaderRepository readerRepository,
            FeeRepository feeRepository,
            AddressRepository addressRepository
    ) {
        return args -> {
            log.info("Preloading " + readerRepository.save(new Reader("Bilbo", "Baggins")));
            log.info("Preloading " + readerRepository.save(new Reader("Frodo", "Baggins")));
            log.info("Mocking " + mock(readerRepository, feeRepository, addressRepository));
        };
    }

    private String mock(
            ReaderRepository readerRepository,
            FeeRepository feeRepository,
            AddressRepository addressRepository
    ) {
        Reader reader = new Reader("Jozef", "Mrkvička");

        Address address = new Address();
        address.setStreet("Ilkovicova");
        address.setNumber("1/2");
        address.setCity("Bratislava");
        address.setZip("12345");
        address.setReader(reader);

        Fee fee = new Fee();
        fee.setAmount(2.35);
        fee.setPaid(false);
        fee.setValid_from(new Date());
        fee.setReader(reader);

        reader.setAddress(address);
        readerRepository.save(reader);
        feeRepository.save(fee);

        return "Success";
    }
}
