package pis_library.soapClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import sk.stuba.fiit.predmety.pis.pis.validator.types.ValidateEmail;

@Configuration
public class ClientConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(ValidateEmail.class.getPackageName());

        return marshaller;
    }

    @Bean
    public ValidatorClient validatorClient(Jaxb2Marshaller marshaller) {
        ValidatorClient client = new ValidatorClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
