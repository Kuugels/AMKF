/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author Samuli Käkönen
 */
public class ContactPageController extends Template implements Initializable {

    @FXML
    private Text contactData;
    @FXML
    private Text email;
    @FXML
    private Text address;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initLsMe();//Lataa käytetyn kielen
        createHandlers();//Luo handlerit sivupalkin nappuloille
        
        updateGUI();
    }    

    @Override
    public void updateGUI() {
        closeButton.setText(messages.getString("shutdown"));
        kyselyBtn.setText(messages.getString("topEducations"));
        koulutuksetBtn.setText(messages.getString("educations"));
        yhteystiedotBtn.setText(messages.getString("contactinfo"));
        
        contactData.setText(messages.getString("contactinfo"));
        email.setText(messages.getString("email"));
        address.setText(messages.getString("address"));
    }

    @Override
    public void closeButtonAction() {
        kone.resetPisteet();
        kone.sulje();
        System.out.println("Tietokantayhteys suljettu");
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
        
        System.exit(0);
    }
    
}
