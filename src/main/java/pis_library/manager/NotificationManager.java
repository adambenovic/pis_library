package pis_library.manager;

import org.springframework.stereotype.Component;
import pis_library.response.ValidateResponseModel;
import pis_library.soapClient.EmailNotificationClient;
import pis_library.soapClient.SMSNotificationClient;

@Component
public class NotificationManager {
    private final SMSNotificationClient smsNotificationClient;
    private final EmailNotificationClient emailNotificationClient;


    public NotificationManager(SMSNotificationClient smsNotificationClient, EmailNotificationClient emailNotificationClient) {
        this.smsNotificationClient = smsNotificationClient;
        this.emailNotificationClient = emailNotificationClient;
    }

    public ValidateResponseModel notifyEmail(String contact, String message, String subject) {
        return new ValidateResponseModel(this.emailNotificationClient.notifyEmail(contact, subject, message));
    }

    public ValidateResponseModel notifySMS(String contact, String message, String subject) {
        return new ValidateResponseModel(this.smsNotificationClient.notifySMS(contact, subject, message));
    }
}
