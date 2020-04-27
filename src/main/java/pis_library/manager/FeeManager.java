package pis_library.manager;

import org.springframework.stereotype.Component;
import pis_library.response.FeeResponseModel;

@Component
public class FeeManager {
    //Coefficient is the percentage the type gets off of the base amount
    private final double onlineCoeff = 0.2;
    private final double ztpKidsRetireeCoeff = 0.5;
    private final double studentCoeff = 0.25;
    private final double baseAmount = 10;

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
}
