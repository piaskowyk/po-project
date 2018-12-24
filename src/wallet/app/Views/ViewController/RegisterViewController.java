package wallet.app.Views.ViewController;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import wallet.app.Helpers.Postman;
import wallet.app.Views.ViewsManager;
import wallet.server.Forms.Register;
import wallet.server.Responses.DataResponses.StandardResult;


public class RegisterViewController {
    @FXML
    private Button sendRegisterBtn;

    @FXML
    private Label returnBtn, statusText;

    @FXML
    private TextField nameInput, surnameInput, emailInput, passwordInput;

    public void initialize(){
        returnBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, returnBtnOnClick);
        sendRegisterBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, sendRegisterBtnOnClick);
    }

    EventHandler returnBtnOnClick = new EventHandler(){
        @Override
        public void handle(Event event) {
            ViewsManager.loadView(ViewsManager.Views.LOGIN);
        }
    };

    EventHandler sendRegisterBtnOnClick = new EventHandler(){
        @Override
        public void handle(Event event) {
            statusText.setText("Waiting...");

            Register registerForm = new Register();
            registerForm.setName(nameInput.getText());
            registerForm.setSurname(surnameInput.getText());
            registerForm.setEmail(emailInput.getText());
            registerForm.setPassword(passwordInput.getText());

            Postman<StandardResult> postman = new Postman<StandardResult>();
            StandardResult loginResponse = postman.send(registerForm, StandardResult.class, Postman.Api.REGISTER);

            if(loginResponse.getStatus()){
                statusText.setText("Account is ready to login.");
            } else {
                statusText.setText("Wrong data. Tray again.");
            }
        }
    };

}