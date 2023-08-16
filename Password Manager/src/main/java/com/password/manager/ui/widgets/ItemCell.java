package com.password.manager.ui.widgets;

import com.password.manager.Assets;
import com.password.manager.entity.PasswordData;
import com.password.manager.ui.controllers.HomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.util.ResourceBundle;

/**
 * @author XDSSWAR
 * Created on 03/16/2023
 */
public class ItemCell<T extends PasswordData> implements Callback<ListView<T>, ListCell<T>> {
    private final HomeController controller;
    private Parent parent = null;

    /**
     * We need the Home controller to save/update/delete from the cell
     * @param controller HomeController
     */
    public ItemCell(HomeController controller) {
        this.controller = controller;
    }

    @Override
    public ListCell<T> call(ListView<T> param) {
        return new ListCell<>(){
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    //Now we load the item fxml and pass this as this class is its controller
                    parent= Assets.load("/com/password/manager/fxml/item.fxml", new ItemController(item));
                    if (parent!=null){
                        setGraphic(parent);
                    }
                }
                setText(null);
            }
        };
    }

    private static class ItemController implements  Initializable {

        @FXML
        private Button btnView;
        @FXML
        private Button btnHide;
        @FXML
        private Pane itemC;
        @FXML
        private PasswordField passwordField;
        @FXML
        private TextField titleField;
        @FXML
        private TextField urlField;
        @FXML
        private TextField usernameField;
        @FXML
        private TextField passwordField2;
        private final PasswordData item;

        public ItemController(PasswordData item) {
            this.item = item;
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            /*
             * Here we load the item info, the item contains all info
             */
            //System.out.println("test");
            //titleField.setText(item.getTitle());
            //usernameField.setText(item.getUsername());
            //passwordField.setText(item.getPassword());
            //passwordField2.setText(item.getPassword());
            //urlField.setText(item.getUrl());
            passwordField2.setVisible(false);
            passwordField.setVisible(true);

            /*
             * Hera add events
             */
            btnView.setOnAction(event -> {

                if(passwordField2.isVisible()){
                    passwordField.setText(passwordField2.getText());
                } else {
                    passwordField.setVisible(false);
                    passwordField2.setVisible(true);
                    passwordField2.setText(passwordField.getText());
                }
            });

            btnHide.setOnAction(event -> {
                if(!passwordField.isVisible()){
                    passwordField.setVisible(true);
                    passwordField2.setVisible(false);
                    passwordField.setText(passwordField2.getText());
                }
            });
        }
    }
}


