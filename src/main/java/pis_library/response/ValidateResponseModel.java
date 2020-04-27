package pis_library.response;

public class ValidateResponseModel {
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public ValidateResponseModel(boolean valid) {
        this.valid = valid;
    }
}
