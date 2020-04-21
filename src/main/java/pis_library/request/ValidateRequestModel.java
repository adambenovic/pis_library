package pis_library.request;

public class ValidateRequestModel {
    private String value;
    private String type;

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
        return this.type.equals("email");
    }

    public boolean isPhone()
    {
        return this.type.equals("phone");
    }
}
