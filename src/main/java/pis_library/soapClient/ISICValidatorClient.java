package pis_library.soapClient;

import localhost._8000.api.ws.isicvalidator.ObjectFactory;
import localhost._8000.api.ws.isicvalidator.ValidateISICRequest;
import localhost._8000.api.ws.isicvalidator.ValidateISICResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import pis_library.property.SOAPProperties;

public class ISICValidatorClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(ValidatorClient.class);

    private final SOAPProperties soapProperties;

    @Autowired
    public ISICValidatorClient(SOAPProperties soapProperties) {
        this.soapProperties = soapProperties;
    }

    private final String isicValidatorUri = "http://localhost:8000/api/ws/isicValidator";

    public boolean validate(String isic) {
        ObjectFactory objectFactory = new ObjectFactory();
        ValidateISICRequest request = objectFactory.createValidateISICRequest();
        request.setIsicNumber(isic);
        log.info("Validating isic " + isic);

        ValidateISICResponse response = (ValidateISICResponse) getWebServiceTemplate()
                .marshalSendAndReceive(isicValidatorUri, request);

        return response.isSuccess();
    }
}
