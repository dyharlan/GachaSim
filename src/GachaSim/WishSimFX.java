package GachaSim;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//The fxml file which contains the layout for the JavaFX UI and the Controller is located in ShitGacha.JavaFX

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dyhar
 */
public class WishSimFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("JavaFX/WishSimFX.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("ShitGacha/Frontend/flat.css";
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
            }

    public static void main(String[] args) {
        launch(args);
    }
    
}
