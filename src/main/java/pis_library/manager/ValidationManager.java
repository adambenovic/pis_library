package pis_library.manager;

import org.springframework.stereotype.Component;
import pis_library.repository.ReaderRepository;
import pis_library.response.ValidatelResponseModel;
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

    public ValidatelResponseModel validateEmail(String email) {
        return new ValidatelResponseModel(this.validatorClient.validateEmail(email));
    }

    public ValidatelResponseModel validatePhone(String phone) {
        return new ValidatelResponseModel(this.validatorClient.validatePhone(phone));
    }

    public ValidatelResponseModel checkDuplicity(String PIN) {
        return new ValidatelResponseModel(!this.readerRepository.findByPIN(PIN));
    }
}
