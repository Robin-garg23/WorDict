package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {
    public static Group root1;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root1 = new Group();
        primaryStage.setTitle("WordDict");
        gamePage page=new gamePage();
        root1.getChildren().add(page.root);
        primaryStage.setScene(new Scene(root1, 500, 500));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
