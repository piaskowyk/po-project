package wallet.server.Responses.DataResponses;

import wallet.server.Responses.BaseResponse;

public class LoginResponse extends BaseResponse {

    private boolean status;
    private String token = "";

    public LoginResponse(){
        super(200, "succes");
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}