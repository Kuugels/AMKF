/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AMKFKone;
import model.Käyttäjä;
import model.LanguageSelection;

/**
 * FXML Controller class
 * Kontrolleri käyttäjän luonti sivulle
 * @author Samuli Käkönen
 */
public class LoginController implements Initializable {

    private String[] maakunnat;

    private ResourceBundle messages;

    private AMKFKone kone = new AMKFKone();
    private Käyttäjä kauttaja = new Käyttäjä();

    @FXML
    private MenuButton maakuntaNappi;
    @FXML
    private TextField etunimi;
    @FXML
    private TextField sukunimi;

    @FXML
    private Text firstname;
    @FXML
    private Text lastname;
    @FXML
    private Button haeButton;

    @FXML
    public javafx.scene.control.Button closeButton;

    String lang;
    LanguageSelection languageSelection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Kielipaketin lataus
        languageSelection = new LanguageSelection();
        languageSelection.langFI();
        messages = languageSelection.resourceBundle();

        //Hakee maakunnat tietokannasta
        maakunnat = kone.getAsuinalueet();
        asetaMaakunnat(maakunnat);
        maakuntaNappi.getStylesheets().add("/amkf/style.css");

        //GUI päivitys
        updateGUI();

    }

    /**
     * Syöttää käyttäjän tiedot tietokantaan ja avaa seuraavan ikkunan
     *
     * @param event ebin event
     * @throws IOException tullee jos eei toemi
     */
    @FXML
    public void haeNappula(ActionEvent event) throws IOException {

        //Hakee etunimi ja sukunimi kentistä tiedot ja asettaa ne Käyttäjä luokkaan
        kauttaja.setNimi(etunimi.getText() + " " + sukunimi.getText());
        System.out.println("Käyttäjän nimi: " + kauttaja.getNimi());

        //Seuraavan scenen lataus
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/amkf/indexMusta.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        System.out.println("Scene vaihdettu");

        kone.sulje();
        System.out.println("Tietokantayhteys suljettu");
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
     * Vaihtaa kielen englanniksi
     */
    @FXML
    public void gbLan() {
        System.out.println("<<<<<<<<<<Kieli vaihdettu>>>>>>>>>>");
        languageSelection.langGB();
        messages = languageSelection.resourceBundle();
        updateGUI();
    }

    /**
     * Asettaa tietokannasta haetut maakunnat valikkoon
     *
     * @param kunnat Tietokannasta haetut maakunnat String taulukossa
     */
    public void asetaMaakunnat(String[] kunnat) {
        for (int i = 0; i < kunnat.length; i++) {
            MenuItem item = new MenuItem(kunnat[i]);
            item.getStyleClass().add("menuItem");
            item.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    kauttaja.setAsuinalue(item.getText());
                    maakuntaNappi.setText(item.getText());
                    System.out.println("Käyttäjän maakunta: " + kauttaja.getAsuinalue());
                }
            });
            maakuntaNappi.getItems().add(item);
        }
    }

    /**
     * Päivittää käyttöliittymän
     */
    public void updateGUI() {
        maakuntaNappi.setText(messages.getString("region"));
        firstname.setText(messages.getString("firstname"));
        lastname.setText(messages.getString("lastname"));
        haeButton.setText(messages.getString("submit"));
        closeButton.setText(messages.getString("shutdown"));
    }

    /**
     * Sulkee ohjelman
     */
    @FXML
    public void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
