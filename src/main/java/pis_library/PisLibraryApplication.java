package pis_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pis_library.property.FileStorageProperties;
import pis_library.property.SOAPProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class,
		SOAPProperties.class
})
public class PisLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PisLibraryApplication.class, args);
	}

}
