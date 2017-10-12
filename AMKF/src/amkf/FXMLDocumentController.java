/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amkf;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.setUserAgentStylesheet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Samuli Käkönen
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    Button pinkButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private final String theme1Url = getClass().getResource("index_pink.css").toExternalForm();
    private final String theme2Url = getClass().getResource("index.css").toExternalForm();

    public void pinkButton(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexMusta.fxml"));/* Exception */
        Scene scene = new Scene(root);
        scene.getStylesheets().remove(theme2Url);
        System.out.println("scene stylesheets on button 1 click: " + scene.getStylesheets());
        if (!scene.getStylesheets().contains(theme1Url)) {
            scene.getStylesheets().add(theme1Url);
        }
        System.out.println("scene stylesheets on button 1 click: " + scene.getStylesheets());

    }

    @FXML
    public void whiteButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexMusta.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public void petrolButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexPetrol.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public void purpleButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexPurple.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public void greenButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexGreen.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public void ala(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("alaPaina.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public javafx.scene.control.Button closeButton;

    @FXML
    public void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    
    public void kysOnAction() {
        MenuButton kys1 = new MenuButton("Valitse");
        for (int i = 1; i < 22; i++) {
            MenuItem kys1k = new MenuItem("Kyllä");
            kys1k.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    kys1.setText("Kyllä");
                }
            });
        }
    }

}
