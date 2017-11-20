/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amkf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.*;

/**
 *
 * @author Samuli Käkönen
 */
public class AMKF extends Application {

    Parent root;

    /**Käynnistää käyttöliittymän
     * @param stage jepulis
     * @throws java.lang.Exception kepulis*/
    @Override
    public void start(Stage stage) throws Exception {

        stage.initStyle(StageStyle.TRANSPARENT);
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        final Scene scene = new Scene(root, Color.TRANSPARENT);
        stage.setScene(scene);

        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
