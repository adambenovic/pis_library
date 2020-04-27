package pis_library.controller;

import org.springframework.web.bind.annotation.*;
import pis_library.exception.UnknownTypeException;
import pis_library.manager.NotificationManager;
import pis_library.request.NotifyRequestModel;
import pis_library.response.ValidateResponseModel;

import java.net.URISyntaxException;

@RestController
@RequestMapping("notification")
public class NotificationController {
    private final NotificationManager manager;

    public NotificationController(NotificationManager manager) {
        this.manager = manager;
    }

    @PostMapping
    @ResponseBody
    public ValidateResponseModel notify(@RequestBody NotifyRequestModel payload) throws URISyntaxException {
        if(payload.isEmail(payload.getContact()))
            return manager.notifyEmail(payload.getContact(), payload.getMessage(), payload.getSubject());
        if(payload.isPhone(payload.getContact()))
            return manager.notifySMS(payload.getContact(), payload.getMessage(), payload.getSubject());

        throw new UnknownTypeException(payload.getContact());
    }
}
