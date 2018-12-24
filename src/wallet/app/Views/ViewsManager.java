package wallet.app.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class ViewsManager {

    private static Stage _primaryStage;
    private static Class _mainClass;
    private static HashMap<String, Scene> allScene = new HashMap<String, Scene>();

    private ViewsManager(){}

    public static void init(Stage primaryStage, Class mainClass){
        _primaryStage = primaryStage;
        _mainClass = mainClass;

        registerScene(Views.LOGIN);
        registerScene(Views.REGISTER);
        registerScene(Views.DASHBOARD);
        registerScene(Views.WALLET);
        registerScene(Views.HISTORY);
    }

    public static void loadView(Views view) {
        _primaryStage.setScene(allScene.get(view.path));
        _primaryStage.setTitle(view.title);
        _primaryStage.show();
    }

    private static void registerScene(Views view){
        try {
            FXMLLoader loader = new FXMLLoader(_mainClass.getResource("Views/src/" + view.path + ".fxml"));
            BorderPane root = null;
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(_mainClass.getResource("Views/src/style.css").toExternalForm());
            scene.getStylesheets().add(_mainClass.getResource("Views/src/" + view.cssPath + ".css").toExternalForm());
            allScene.put(view.path, scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum Views{
        LOGIN("login", "login", "Login to MyWallet"),
        REGISTER("register", "register", "Create new MyWallet account"),
        DASHBOARD("dashboard", "dashboard", "MyWallet"),
        WALLET("wallet", "wallet", "MyWallet"),
        HISTORY("history", "history", "MyWallet");

        String path;
        String cssPath;
        String title;

        Views(String path, String cssPath, String title){
            this.path = path;
            this.cssPath = cssPath;
            this.title = title;
        }
    }

}