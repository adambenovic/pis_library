package pis_library.response;

public class ValidatelResponseModel {
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public ValidatelResponseModel(boolean valid) {
        this.valid = valid;
    }
}
