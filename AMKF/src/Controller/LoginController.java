/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AMKFKone;
import model.Käyttäjä;

/**
 * FXML Controller class
 *
 * @author Samuli Käkönen
 */
public class LoginController implements Initializable {

    private String[] maakunnat;

    private AMKFKone kone = new AMKFKone();
    private Käyttäjä kauttaja = new Käyttäjä();

    @FXML
    private MenuButton maakuntaNappi;

    @FXML
    private TextField etunimi;

    @FXML
    private TextField sukunimi;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Hakee maakunnat tietokannasta
        maakunnat = kone.getAsuinalueet();
        asetaMaakunnat(maakunnat);
        maakuntaNappi.getStylesheets().add("/amkf/style.css");
    }

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

    //Asettaa tietokannasta haetut maakunnat valikkoon
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

    @FXML
    public javafx.scene.control.Button closeButton;

    @FXML
    public void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
