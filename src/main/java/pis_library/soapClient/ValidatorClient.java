package pis_library.soapClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import sk.stuba.fiit.predmety.pis.pis.validator.types.*;

import javax.xml.bind.JAXBElement;

public class ValidatorClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(ValidatorClient.class);

    private final String uri = "http://pis.predmety.fiit.stuba.sk/pis/ws/Validator";

    public boolean validateEmail(String email) {
        ObjectFactory objectFactory = new ObjectFactory();
        ValidateEmail request = objectFactory.createValidateEmail();
        request.setEmail(email);
        log.info("Validating email " + email);

        JAXBElement<ValidateEmail> jaxbRequest = objectFactory.createValidateEmail(request);

        JAXBElement<ValidateEmailResponse> response = (JAXBElement<ValidateEmailResponse>) getWebServiceTemplate()
                .marshalSendAndReceive(uri, jaxbRequest);

        return response.getValue().isSuccess();
    }

    public boolean validatePhone(String phone) {
        ObjectFactory objectFactory = new ObjectFactory();
        ValidatePhone request = objectFactory.createValidatePhone();
        request.setPhone(phone);
        log.info("Validating phone " + phone);

        JAXBElement<ValidatePhone> jaxbRequest = objectFactory.createValidatePhone(request);

        JAXBElement<ValidatePhoneResponse> response = (JAXBElement<ValidatePhoneResponse>) getWebServiceTemplate()
                .marshalSendAndReceive(uri, jaxbRequest);

        return response.getValue().isSuccess();
    }
}
