package pis_library.controller;

import org.springframework.web.bind.annotation.*;
import pis_library.exception.UnknownTypeException;
import pis_library.request.ValidateRequestModel;
import pis_library.response.ValidatelResponseModel;
import pis_library.soapClient.ValidatorClient;

import java.net.URISyntaxException;

@RestController
@RequestMapping("validation")
public class ValidationController {
    private final ValidatorClient validatorClient;

    public ValidationController(
            ValidatorClient validatorClient
    ) {
        this.validatorClient = validatorClient;
    }

    @PostMapping
    @ResponseBody
    ValidatelResponseModel validate(@RequestBody ValidateRequestModel payload) throws URISyntaxException {
        if(payload.isEmail())
            return new ValidatelResponseModel(this.validatorClient.validateEmail(payload.getValue()));
        if(payload.isPhone())
            return new ValidatelResponseModel(this.validatorClient.validatePhone(payload.getValue()));

        throw new UnknownTypeException(payload.getType());
    }
}
