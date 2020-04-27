package pis_library.manager;

import org.springframework.stereotype.Component;
import pis_library.repository.ReaderRepository;
import pis_library.response.ValidateResponseModel;
import pis_library.soapClient.ValidatorClient;


@Component
public class ValidationManager {

    private final ValidatorClient validatorClient;

    private final ReaderRepository readerRepository;

    public ValidationManager(
            ValidatorClient validatorClient,
            ReaderRepository readerRepository
    ) {
        this.validatorClient = validatorClient;
        this.readerRepository = readerRepository;
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
}
