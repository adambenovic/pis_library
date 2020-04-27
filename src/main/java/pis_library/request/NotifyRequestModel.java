package pis_library.request;

public class NotifyRequestModel {
    private String message;
    private String subject;
    private String contact;

    private final String email = "email";
    private final String phone = "phone";

    public boolean isEmail(String contact) {
        return contact.contains("@");
    }

    public boolean isPhone(String contact) {
        return !contact.contains("@");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
