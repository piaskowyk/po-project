package wallet.App.Views.ViewController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import wallet.App.Helpers.AuthorizationManager;
import wallet.App.Views.IViewController;
import wallet.App.Views.ViewController.Components.Menu;
import wallet.App.Views.ViewController.ThreadsActions.LoadDashboardDataThread;

public class DashboardViewController implements IViewController {

    @FXML
    private BorderPane areaChartContainer, circleChartContainer;

    @FXML
    private Label accountStateLabel, incomingStatusLabel, outcomingStatusLabel, statusLabel;

    @FXML
    private VBox menuBar;

    public void initialize(){
        Menu.registerMenu(menuBar);

        if(AuthorizationManager.isAuthorized()){
            LoadDashboardDataThread loadDashboardDataThread = new LoadDashboardDataThread(this);
            Thread getData = new Thread(loadDashboardDataThread);
            Platform.runLater(getData);
        }
    }

    @Override
    public void onLoad() {
        LoadDashboardDataThread loadDashboardDataThread = new LoadDashboardDataThread(this);
        Thread getData = new Thread(loadDashboardDataThread);
        Platform.runLater(getData);
    }

    public BorderPane getAreaChartContainer() {
        return areaChartContainer;
    }

    public BorderPane getCircleChartContainer() {
        return circleChartContainer;
    }

    public Label getAccountStateLabel() {
        return accountStateLabel;
    }

    public Label getIncomingStatusLabel() {
        return incomingStatusLabel;
    }

    public Label getOutcomingStatusLabel() {
        return outcomingStatusLabel;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }

    public VBox getMenuBar() {
        return menuBar;
    }
}