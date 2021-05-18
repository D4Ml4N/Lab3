package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Kalkulator do blachy");
        primaryStage.setScene(new Scene(root, 300, 275));
        // primaryStage.setScene(new Scene(root, 600, 440));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

