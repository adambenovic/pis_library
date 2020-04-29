package pis_library.request;

public class ValidateRequestModel {
    private String value;
    private String type;
    private final String email = "email";
    private final String phone = "phone";
    private final String pin = "personal_identification_number";
    private final String isic = "isic";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEmail()
    {
        return this.type.equals(email);
    }

    public boolean isPhone()
    {
        return this.type.equals(phone);
    }

    public boolean isPIN()
    {
        return this.type.equals(pin);
    }

    public boolean isISIC()
    {
        return this.type.equals(isic);
    }
}
