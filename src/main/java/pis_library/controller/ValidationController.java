package pis_library.controller;

import org.springframework.web.bind.annotation.*;
import pis_library.exception.UnknownTypeException;
import pis_library.manager.ValidationManager;
import pis_library.request.ValidateRequestModel;
import pis_library.response.ValidateResponseModel;

import java.net.URISyntaxException;

@RestController
@RequestMapping("validation")
public class ValidationController {
    private final ValidationManager manager;

    public ValidationController(ValidationManager manager) {
        this.manager = manager;
    }

    @PostMapping
    @ResponseBody
    public ValidateResponseModel validate(@RequestBody ValidateRequestModel payload) throws URISyntaxException {
        if(payload.isEmail())
            return this.manager.validateEmail(payload.getValue());
        if(payload.isPhone())
            return this.manager.validatePhone(payload.getValue());
        if(payload.isPIN())
            return this.manager.checkDuplicity(payload.getValue());

        throw new UnknownTypeException(payload.getType());
    }
}
