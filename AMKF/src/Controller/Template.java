/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.AMKFKone;
import model.LanguageSelection;

/**
 * Pohja kaikile muille kontrollereille
 *
 * @author Samuli Käkönen
 */
public abstract class Template {

    public AMKFKone kone = new AMKFKone();

    @FXML
    public Button closeButton;
    @FXML
    public Button kyselyBtn;
    @FXML
    public Button yhteystiedotBtn;
    @FXML
    public Button koulutuksetBtn;
    /**
     * Semmone eläin
     */
    @FXML
    public Button sopuli;

    public LanguageSelection languageSelection;
    public ResourceBundle messages;

    public abstract void updateGUI();
    public abstract void closeButtonAction();

    /**
     * Lataa kielipaketin
     */
    public void initLsMe() {
        languageSelection = LanguageSelection.getInstance();
        messages = languageSelection.resourceBundle();

    }
    
    /**
     * Luo handlerit sivupalkin nappuloille
     */
    public void createHandlers() {
        koulutuksetBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    //Seuraavan scenen lataus
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("/amkf/AllEducations.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    System.out.println("Scene vaihdettu");
                }catch (IOException e) {
                    System.out.println("Jees very mutch errors vi häve hier");
                }
            }
        });
        
        yhteystiedotBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    //Seuraavan scenen lataus
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("/amkf/ContactPage.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    System.out.println("Scene vaihdettu");
                }catch (IOException e) {
                    System.out.println("Jees very mutch errors vi häve hier");
                }
            }
        });
        
        kyselyBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    //Seuraavan scenen lataus
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("/amkf/Koulutukset.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    System.out.println("Scene vaihdettu");
                }catch (IOException e) {
                    System.out.println("Jees very mutch errors vi häve hier");
                }
            }
        });
        
        sopuli.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    //Seuraavan scenen lataus
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("/amkf/indexMusta.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    System.out.println("Scene vaihdettu");
                }catch (IOException e) {
                    System.out.println("Jees very mutch errors vi häve hier");
                }
            }
        });
    }

    /**
     * Vaihtaa kielen viroksi
     */
    @FXML
    public void eeLan() {
        System.out.println("<<<<<<<<<<Kieli vaihdettu>>>>>>>>>>");
        languageSelection.langEE();
        messages = languageSelection.resourceBundle();
        updateGUI();
    }

    /**
     * Vaihtaa kielen suomeksi
     */
    @FXML
    public void fiLan() {
        System.out.println("<<<<<<<<<<Kieli vaihdettu>>>>>>>>>>");
        languageSelection.langFI();
        messages = languageSelection.resourceBundle();
        updateGUI();
    }

    /**
     * Vaihtaa kielen englantiin
     */
    @FXML
    public void gbLan() {
        System.out.println("<<<<<<<<<<Kieli vaihdettu>>>>>>>>>>");
        languageSelection.langGB();
        messages = languageSelection.resourceBundle();
        updateGUI();
    }

}
