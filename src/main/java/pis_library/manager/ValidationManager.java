package pis_library.manager;

import org.springframework.stereotype.Component;
import pis_library.repository.ReaderRepository;
import pis_library.response.ValidateResponseModel;
import pis_library.soapClient.ISICValidatorClient;
import pis_library.soapClient.ValidatorClient;


@Component
public class ValidationManager {

    private final ValidatorClient validatorClient;

    private final ReaderRepository readerRepository;

    private final ISICValidatorClient isicClient;

    public ValidationManager(
            ValidatorClient validatorClient,
            ReaderRepository readerRepository,
            ISICValidatorClient isicClient
    ) {
        this.validatorClient = validatorClient;
        this.readerRepository = readerRepository;
        this.isicClient = isicClient;
    }

    public ValidateResponseModel validateEmail(String email) {
        return new ValidateResponseModel(this.validatorClient.validateEmail(email));
    }

    public ValidateResponseModel validatePhone(String phone) {
        return new ValidateResponseModel(this.validatorClient.validatePhone(phone));
    }

    public ValidateResponseModel checkDuplicity(String PIN) {
        return new ValidateResponseModel(!this.readerRepository.findByPIN(PIN));
    }

    public ValidateResponseModel validateISIC(String isicNUmber) {
        return new ValidateResponseModel(this.isicClient.validate(isicNUmber));
    }
}
