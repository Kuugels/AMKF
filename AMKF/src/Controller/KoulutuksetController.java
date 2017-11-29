/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.AMKFKone;

/**
 * FXML Controller class
 *
 * @author Samuli Käkönen
 */
public class KoulutuksetController implements Initializable {
    
    private AMKFKone kone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int koulutusmäärä = 5;
        String[] topKoulutukset = kone.getTopKoulutukset(koulutusmäärä);
        String[] kuvaukset = new String[topKoulutukset.length];
        
        for(int i = 0; i<topKoulutukset.length; i++){
            kuvaukset[i] = kone.getKuvaus(topKoulutukset[i]);
        }
        
    }    
    
}
