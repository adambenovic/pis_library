package pis_library.manager;

import org.springframework.stereotype.Component;
import pis_library.entity.Fee;
import pis_library.entity.Reader;
import pis_library.repository.FeeRepository;
import pis_library.response.FeeResponseModel;

import java.util.Calendar;
import java.util.Date;

@Component
public class FeeManager {
    //Coefficient is the percentage the type gets off of the base amount
    private final double onlineCoeff = 0.2;
    private final double ztpKidsRetireeCoeff = 0.5;
    private final double studentCoeff = 0.25;
    private final double baseAmount = 10;

    private final FeeRepository feeRepository;

    public FeeManager(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public FeeResponseModel generateByType(String type) {
        switch (type)
        {
            case "student":
                return new FeeResponseModel(baseAmount, onlineCoeff + studentCoeff);
            case "ztp":
            case "kid":
            case "retiree":
                return new FeeResponseModel(baseAmount, onlineCoeff + ztpKidsRetireeCoeff);
            default:
                return new FeeResponseModel(baseAmount, 0);
        }
    }

    public void saveFeeToReader(Reader reader) {
        FeeResponseModel generatedFee = this.generateByType(reader.getType());
        Fee fee = new Fee();
        fee.setAmount(generatedFee.getAmount());
        fee.setPaid(false);
        fee.setReader(reader);

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        Date nextYear = cal.getTime();

        fee.setValid_from(today);
        fee.setValid_to(nextYear);

        this.feeRepository.save(fee);
    }
}
