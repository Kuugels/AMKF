/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Locale;
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

    public AMKFKone kone = new AMKFKone();
    
    @FXML
    public Button closeButton;
    @FXML
    public Button kyselyBtn;
    @FXML
    public Button yhteystiedotBtn;
    @FXML
    public Button koulutuksetBtn;

    public LanguageSelection languageSelection;
    public ResourceBundle messages;
    
    public abstract void updateGUI();
    
    public void initLsMe() {
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
    
    public abstract void closeButtonAction();

}
