package pis_library.soapClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pis_library.property.SOAPProperties;
import sk.stuba.fiit.predmety.pis.pis.notificationservices.email.types.Notify;
import sk.stuba.fiit.predmety.pis.pis.validator.types.ValidateEmail;

@Configuration
public class ClientConfiguration {
    private final SOAPProperties soapProperties;

    public ClientConfiguration(SOAPProperties soapProperties) {
        this.soapProperties = soapProperties;
    }

    @Bean
    public ValidatorClient validatorClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(ValidateEmail.class.getPackageName());

        ValidatorClient client = new ValidatorClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

    @Bean
    public EmailNotificationClient emailNotificationClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(Notify.class.getPackageName());
        EmailNotificationClient client = new EmailNotificationClient(soapProperties);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

    @Bean
    public SMSNotificationClient smsNotificationClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(sk.stuba.fiit.predmety.pis.pis.notificationservices.sms.types.Notify.class.getPackageName());
        SMSNotificationClient client = new SMSNotificationClient(soapProperties);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
