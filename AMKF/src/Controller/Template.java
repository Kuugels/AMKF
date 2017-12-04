/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.AMKFKone;
import model.LanguageSelection;

/**
 * Pohja kaikile muille kontrollereille paitsi loginControllerille
 * @author Samuli Käkönen
 */
public abstract class Template {

    private AMKFKone kone;
    
    @FXML
    Button closeButton;
    @FXML
    Button kyselyBtn;
    @FXML
    Button yhteystiedotBtn;
    @FXML
    Button koulutuksetBtn;

    private String lang;
    private LanguageSelection languageSelection;
    private ResourceBundle messages;
    
    public abstract void updateGUI();
    
    public void init() {
        languageSelection = new LanguageSelection();
        messages = languageSelection.resourceBundle();
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
    
    /**
     * Sulkee ohjelman
     */
    @FXML
    public void closeButtonAction() {
        kone.resetPisteet();//KONETTA EI OO LUOTU NII TULEE ERRRRROR
        kone.sulje();
        System.out.println("Tietokantayhteys suljettu");
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
