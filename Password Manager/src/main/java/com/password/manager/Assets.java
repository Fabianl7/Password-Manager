package com.password.manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.net.URL;

/**
 * @author XDSSWAR
 * Created on 03/16/2023
 */
public final class Assets {
    public static final String APP_NAME="Password Manager";
    public static final String VERSION="1.0.0";

    /**
     * Get resource url
     * @param location String location
     * @return URL
     */
    public static URL load(String location){
        return Assets.class.getResource(location);
    }

    /**
     * Load fxml file
     * @param location String location
     * @param controller Object controller, set it to nullif you specify the controller in the fxml file
     * @return Parent
     */
    public static Parent load(String location, Object controller){
        try {
            FXMLLoader loader = new FXMLLoader(load(location));
            if (controller != null) {
                loader.setController(controller);
            }
            return loader.load();
        }catch (Exception e){
            return null;
        }
    }
}
