package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Employee Manager 2000");
        Scene myScene = new Scene(root, 800, 600);


        primaryStage.setScene(myScene);
        primaryStage.show();
    }
//check

    public static void main(String[] args) {
        launch(args);
    }
}
