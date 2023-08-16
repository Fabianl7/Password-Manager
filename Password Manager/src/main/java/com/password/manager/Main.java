package com.password.manager;

import com.password.manager.ui.controllers.HomeController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author XDSSWAR
 * Created on 03/16/2023
 */
public class Main extends Application {
    private double x, y;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle(Assets.APP_NAME);
        //Here we pass the controller using the new keyword and the name of the class
        //I don't pass controller into the fxml file itself
        Parent parent = Assets.load("/com/password/manager/fxml/home.fxml",new HomeController());
        if (parent!=null) {
            //drag it here
            parent.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            parent.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);

            });
            stage.setScene(new Scene(parent));
            stage.initStyle(StageStyle.UNDECORATED);
        }
        stage.show();
    }
}
