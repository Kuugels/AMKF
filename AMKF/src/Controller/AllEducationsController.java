/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AMKFKone;
import model.LanguageSelection;

/**
 * FXML Controller class
 *
 * @author Samuli Käkönen
 */
public class AllEducationsController extends Template implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private ScrollPane scrollPane;
    
    String[] educations;

    /**
     * Initializes the controller class.
     * @param url urlipurli
     * @param rb re soossi buntle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listAllEducations();
        initLsMe();//Lataa käytetyn kielen
        createHandlers();//Luo handlerit sivupalkin nappuloille
        updateGUI();
    }

    /**
     * Creates ListView for all educations in database
     */
    public void listAllEducations() {
        ListView list = new ListView();
        educations = kone.getKoulutukset();

        for (String education : educations) {
            Text txt = new Text(education);
            list.getItems().add(txt);
        }

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                listItemHandler(list, educations);
            }
        });

        borderPane.setCenter(list);
        scrollPane.setContent(borderPane);
        
    }
    
    /**
     * Runs when ListView Object is clicked
     * @param list ListView
     * @param educations String array of educations in database
     */
    private void listItemHandler(ListView list,String[] educations) {
        Text txt = (Text) list.getSelectionModel().getSelectedItem();
        txt.setWrappingWidth(700); //Asettaa tekstin max pituudeksi 700px
        String origTxt = educations[list.getSelectionModel().getSelectedIndex()];//Alkuperäinen teksti 
        if (!txt.getText().contains("Koulut:")) {
            String schools = "\nKuvaus: " + kone.getKuvaus(educations[list.getSelectionModel().getSelectedIndex()]) +  "\nKoulut:";
            for (String school : kone.getKoulutForKoulutus(origTxt)) {
                schools += "\n>" + school;
            }
            txt.setText(txt.getText() + schools);
        }else {
            txt.setText(origTxt);
        }
    }

    @Override
    public void updateGUI() {
        closeButton.setText(messages.getString("shutdown"));
        kyselyBtn.setText(messages.getString("topEducations"));
        koulutuksetBtn.setText(messages.getString("educations"));
        yhteystiedotBtn.setText(messages.getString("contactinfo"));
        sopuli.setText(messages.getString("questions"));
    }

    /**
     * Sulkee ohjelman
     */
    @FXML
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
