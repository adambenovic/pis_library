package pis_library;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pis_library.entity.Reader;
import pis_library.repository.ReaderRepository;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(ReaderRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Reader("Bilbo", "Baggins")));
            log.info("Preloading " + repository.save(new Reader("Frodo", "Baggins")));
        };
    }
}
