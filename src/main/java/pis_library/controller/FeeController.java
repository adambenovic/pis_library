package pis_library.controller;

import org.springframework.web.bind.annotation.*;
import pis_library.manager.FeeManager;
import pis_library.response.FeeResponseModel;

@RestController
@RequestMapping("fee")
public class FeeController {

    private FeeManager feeManager;

    public FeeController(FeeManager feeManager) {
        this.feeManager = feeManager;
    }

    @GetMapping("/generate")
    @ResponseBody
    public FeeResponseModel generate(@RequestParam String type) {
        return this.feeManager.generateByType(type);
    }
}
