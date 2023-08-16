package com.password.manager.ui.controllers;

import com.password.manager.entity.PasswordData;
import com.password.manager.ui.widgets.ItemCell;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.io.*;

/**
 * @author XDSSWAR
 * Created on 03/16/2023
 */
public class HomeController implements Initializable {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnClose2;

    @FXML
    private Button btnClose3;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnSave;

    @FXML
    private ListView<PasswordData> listView;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private Pane pnlLogin;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    private int c=0;

    public ArrayList<PasswordData> list;

    public void setPassData(String password){
        list.get(0).setPassword(password);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File f = new File("info.txt");

        //Set the cell factory to render the item view
        listView.setCellFactory(new ItemCell<>(this));
        list = new ArrayList<>();
        //ItemCell ic = new ItemCell(this);
        //ArrayList<ItemCell> arr = new ArrayList<>();

        // Read and load the passwords
        if(f.exists() && !f.isDirectory()) {
            try{
                BufferedReader br = new BufferedReader(
                        new FileReader("C:\\Users\\Fabia\\Downloads\\Password Manager\\info.txt"));
                String s;
                while((s = br.readLine()) != null){
                    System.out.println(s);
                }
                br.close();
            } catch(Exception e){
                return;
            }
        }
        /*
         * Add event
         */

        btnAdd.setOnAction(event -> {
            //System.out.println(ic.getPasswordFieldVal());
            PasswordData data=new PasswordData();
            data.setTitle("Title "+(c+1));
            data.setUsername("Username");
            data.setPassword("Password");
            data.setUrl("https://google.com");
            listView.getItems().add(data);
            list.add(data);
            //arr.add(new ItemCell(this));
            c++;
        });

        /*
         * Save Event
         */

        btnSave.setOnAction(event -> {

            System.out.println(listView.getItems().get(0));
            try {
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter("C:\\Users\\Fabia\\Downloads\\Password Manager\\info.txt"));
                bw.write(c + "\n");

                for(int i = 0; i < c; i++)
                    bw.write(list.get(i).getTitle() + " " +
                            list.get(i).getUsername() + " " +
                            list.get(i).getPassword() + " " +
                            list.get(i).getUrl() + " \n");
                bw.close();
            } catch(Exception e){
                return;
            }
        });

        /*
         * Close
         */
        btnClose.setOnAction(event -> Platform.exit());
    }
}