package pis_library.soapClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import pis_library.property.SOAPProperties;
import sk.stuba.fiit.predmety.pis.pis.notificationservices.email.types.Notify;
import sk.stuba.fiit.predmety.pis.pis.notificationservices.email.types.NotifyResponse;
import sk.stuba.fiit.predmety.pis.pis.notificationservices.email.types.ObjectFactory;

import javax.xml.bind.JAXBElement;

public class EmailNotificationClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(ValidatorClient.class);

    private final SOAPProperties soapProperties;

    @Autowired
    public EmailNotificationClient(SOAPProperties soapProperties) {
        this.soapProperties = soapProperties;
    }

    private final String emailNotifUri = "http://pis.predmety.fiit.stuba.sk/pis/ws/NotificationServices/Email";

    public boolean notifyEmail(String email, String subject, String message) {
        ObjectFactory objectFactory = new ObjectFactory();
        Notify request = objectFactory.createNotify();
        log.info(soapProperties.getTeam());
        request.setTeamId(soapProperties.getTeam());
        request.setPassword(soapProperties.getPassword());
        request.setEmail(email);
        request.setSubject(subject);
        request.setMessage(message);
        log.info("Sent notification to " + email);

        JAXBElement<Notify> jaxbRequest = objectFactory.createNotify(request);

        JAXBElement<NotifyResponse> response = (JAXBElement<NotifyResponse>) getWebServiceTemplate()
                .marshalSendAndReceive(emailNotifUri, jaxbRequest);

        return response.getValue().isSuccess();
    }
}