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

/**
 * FXML Controller class
 *
 * @author Samuli Käkönen
 */
public class KoulutuksetController extends Template implements Initializable {

    @FXML
    BorderPane borderPane;

    @FXML
    ScrollPane scrollPane;

    String lang;

    private String[] topKoulutukset;
    private String[] kuvaukset;

    
    /**
     * Initializes the controller class.
     * @param url urlipurli
     * @param rb soossi buntle mallia resource
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initLsMe();//Lataa käytetyn kielen
        createHandlers();//Luo handlerit sivupalkin nappuloille
        
        int koulutusmäärä = 5;

        topKoulutukset = kone.getTopKoulutukset(koulutusmäärä);
        kuvaukset = new String[topKoulutukset.length];

        updateGUI();

        for (int i = 0; i < topKoulutukset.length; i++) {
            kuvaukset[i] = kone.getKuvaus(topKoulutukset[i]);
        }

        for (int i = 0; i < kuvaukset.length; i++) {
            System.out.println("------------------Koulutus" + (i + 1) + "  -------------------");
            System.out.println("Koulutus: " + topKoulutukset[i]);
            System.out.println("Kuvaus: " + kuvaukset[i]);
            System.out.println("------------------------------------------------");
        }
        createListOfEducations();
    }

    /**
     * Luo listviewin ja asettaa siihen jokaisen koulutuksen
     */
    private void createListOfEducations() {
        ListView list = new ListView();
        if (messages == null) {
            System.out.println("Messages on null");
        }
        Button btn = new Button(messages.getString("questions"));
        Text ed = new Text("");
        
        
        for (int i = 0; i < topKoulutukset.length; i++) {
            ed = new Text(topKoulutukset[i] + "\n" + messages.getString("description") + ": " + kuvaukset[i]);
            ed.setWrappingWidth(700);
            list.getItems().addAll(ed);
            list.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    listItemHandler(list);
                }
            });
        }
        
        list.getItems().add(btn);
        borderPane.setCenter(list);
        scrollPane.setContent(borderPane);
    }

    private void listItemHandler(ListView list) {
        Text txt = (Text) list.getSelectionModel().getSelectedItem();
        String origTxt = topKoulutukset[list.getSelectionModel().getSelectedIndex()] + "\n" + messages.getString("description") + ": " + kuvaukset[list.getSelectionModel().getSelectedIndex()];
        if (!txt.getText().contains("Koulut:")) {
            String schools = "\nKoulut:";
            for (String school : kone.getKoulutForKoulutus(topKoulutukset[list.getSelectionModel().getSelectedIndex()])) {
                schools += "\n>" + school;
            }
            txt.setText(txt.getText() + schools);
        }else {
            txt.setText(origTxt);
        }
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

    }
    
    @Override
    public void updateGUI() {
        closeButton.setText(messages.getString("shutdown"));
        kyselyBtn.setText(messages.getString("questions"));
        koulutuksetBtn.setText(messages.getString("educations"));
        yhteystiedotBtn.setText(messages.getString("contactinfo"));
    }

}
