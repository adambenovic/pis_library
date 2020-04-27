package pis_library.soapClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import pis_library.property.SOAPProperties;
import sk.stuba.fiit.predmety.pis.pis.notificationservices.sms.types.Notify;
import sk.stuba.fiit.predmety.pis.pis.notificationservices.sms.types.NotifyResponse;
import sk.stuba.fiit.predmety.pis.pis.notificationservices.sms.types.ObjectFactory;

import javax.xml.bind.JAXBElement;

public class SMSNotificationClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(ValidatorClient.class);

    private final SOAPProperties soapProperties;

    @Autowired
    public SMSNotificationClient(SOAPProperties soapProperties) {
        this.soapProperties = soapProperties;
    }

    private final String smsNotifUri   = "http://pis.predmety.fiit.stuba.sk/pis/ws/NotificationServices/SMS";

    public boolean notifySMS(String phone, String subject, String message) {
        ObjectFactory objectFactory = new sk.stuba.fiit.predmety.pis.pis.notificationservices.sms.types.ObjectFactory();
        Notify request = objectFactory.createNotify();
        log.info(soapProperties.getTeam());
        request.setTeamId(soapProperties.getTeam());
        request.setPassword(soapProperties.getPassword());
        request.setPhone(phone);
        request.setSubject(subject);
        request.setMessage(message);
        log.info("Sent notification to " + phone);

        JAXBElement<Notify> jaxbRequest = objectFactory.createNotify(request);

        JAXBElement<NotifyResponse> response = (JAXBElement<NotifyResponse>) getWebServiceTemplate()
                .marshalSendAndReceive(smsNotifUri, jaxbRequest);

        return response.getValue().isSuccess();
    }
}