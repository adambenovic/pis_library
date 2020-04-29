package pis_library.endpoint;

import localhost._8000.api.ws.isicvalidator.ValidateISICRequest;
import localhost._8000.api.ws.isicvalidator.ValidateISICResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pis_library.manager.ValidationManager;

@Endpoint
public class ISICValidatorEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8000/api/ws/isicValidator";

    private final ValidationManager validationManager;

    @Autowired
    public ISICValidatorEndpoint(ValidationManager validationManager) {
        this.validationManager = validationManager;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ValidateISICRequest")
    @ResponsePayload
    public ValidateISICResponse validateISIC(@RequestPayload ValidateISICRequest request) {
        String isic = request.getIsicNumber();
        ValidateISICResponse response = new ValidateISICResponse();

        //TODO logic to isic validation

        response.setSuccess(isic.length() == 10);

        return response;
    }
}
