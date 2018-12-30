package wallet.App.Views.ViewController;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import wallet.App.Helpers.AuthorizationManager;
import wallet.App.Views.IViewController;
import wallet.App.Views.ViewsManager;
import wallet.CommonElements.Helpers.Validator;

public class LoginViewController implements IViewController {

    @FXML
    private Button loginBtn;

    @FXML
    private Label registerBtn, statusText;

    @FXML
    private TextField emailInput, passwordInput;


    public void initialize(){
        registerBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, registerBtnOnClick);
        loginBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, loginBtnOnClick);
    }

    private EventHandler<MouseEvent> registerBtnOnClick = event -> ViewsManager.loadView(ViewsManager.Views.REGISTER);

    private EventHandler<MouseEvent> loginBtnOnClick = new EventHandler<>() {
        @Override
        public void handle(MouseEvent event) {

            if(!Validator.isValidEmail(emailInput.getText())) {
                statusText.setText("Invalid email.");
                return;
            }

            if(passwordInput.getText().length() > 40) {
                statusText.setText("Password is too long.");
                return;
            }

            statusText.setText("Waiting...");

            AuthorizationManager.authorize(emailInput.getText(), passwordInput.getText());

            if(!AuthorizationManager.isAuthorized()){
                statusText.setText("Login failed. Try again.");
            } else {
                ViewsManager.loadView(ViewsManager.Views.DASHBOARD);
            }
        }
    };
}
