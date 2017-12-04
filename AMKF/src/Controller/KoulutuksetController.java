/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AMKFKone;
import model.LanguageSelection;

/**
 * FXML Controller class
 *
 * @author Samuli Käkönen
 */
public class KoulutuksetController implements Initializable {
    
    private AMKFKone kone;

    @FXML
    Button closeButton;
    @FXML
    Button kyselyBtn;
    @FXML
    Button yhteystiedotBtn;
    @FXML
    Button koulutuksetBtn;

    @FXML
    BorderPane borderPane;

    @FXML
    ScrollPane scrollPane;

    String lang;

    private LanguageSelection languageSelection;
    private ResourceBundle messages;

    String[] topKoulutukset;
    String[] kuvaukset;

    Boolean alreadyListed = false;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Kielipaketin lataus
        languageSelection = new LanguageSelection();
        messages = languageSelection.resourceBundle();

        int koulutusmäärä = 5;
        kone = new AMKFKone();
        topKoulutukset = kone.getTopKoulutukset(koulutusmäärä);
        kuvaukset = new String[topKoulutukset.length];

        updateGUI();

        for (int i = 0; i < topKoulutukset.length; i++) {
            kuvaukset[i] = kone.getKuvaus(topKoulutukset[i]);
        }

        for (int i = 0; i < kuvaukset.length; i++) {
            System.out.println("------------------Koulutus" + (i + 1) + "  ------------------");
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
        Button btn = new Button(messages.getString("questions"));
        Text ed;

        for (int i = 0; i < topKoulutukset.length; i++) {
            ed = new Text(topKoulutukset[i] + "\n" + messages.getString("description") + ": " + kuvaukset[i]);
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
        Boolean alreadyListed = false;
        Text txt = (Text) list.getSelectionModel().getSelectedItem();
        final String originalTxt = txt.getText();
        if (alreadyListed) {
            txt.setText(originalTxt);
            alreadyListed = false;
        }else {
            txt.setText(txt.getText() + "\nTÄSSÄ PITÄIS OLLA KOULUT LISTATTUNA");
            alreadyListed = true;
        }
        

    }

    /**
     * Sulkee ohjelman
     */
    @FXML
    public void closeButtonAction() {
        kone.resetPisteet();
        kone.sulje();
        System.out.println("Tietokantayhteys suljettu");
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();

        // do what you have to do
        stage.close();

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

    public void updateGUI() {
        System.out.println(messages.getString("shutdown"));
        closeButton.setText(messages.getString("shutdown"));
        kyselyBtn.setText(messages.getString("questions"));
        koulutuksetBtn.setText(messages.getString("educations"));
        yhteystiedotBtn.setText(messages.getString("contactinfo"));
    }

}
