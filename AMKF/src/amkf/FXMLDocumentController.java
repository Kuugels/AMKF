/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amkf;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import static javafx.application.Application.setUserAgentStylesheet;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Käyttäjä;
import model.AMKFKone;

/**
 *
 * @author Samuli Käkönen
 */
public class FXMLDocumentController implements Initializable {

    private Locale locale;
    private Locale eLocale;
    private ResourceBundle messages;

    @FXML
    Button pinkButton;
    @FXML
    private Button changeLanguage;

    @FXML
    Button kyselyValmis;

    @FXML
    MenuButton kys1;
    @FXML
    MenuButton kys2;
    @FXML
    MenuButton kys3;
    @FXML
    MenuButton kys4;
    @FXML
    MenuButton kys5;
    @FXML
    MenuButton kys6;
    @FXML
    MenuButton kys7;
    @FXML
    MenuButton kys8;
    @FXML
    MenuButton kys9;
    @FXML
    MenuButton kys10;
    @FXML
    MenuButton kys11;
    @FXML
    MenuButton kys12;
    @FXML
    MenuButton kys13;
    @FXML
    MenuButton kys14;
    @FXML
    MenuButton kys15;
    @FXML
    MenuButton kys16;
    @FXML
    MenuButton kys17;
    @FXML
    MenuButton kys18;
    @FXML
    MenuButton kys19;
    @FXML
    MenuButton kys20;
    @FXML
    MenuButton kys21;
    @FXML
    MenuButton kys22;

    ArrayList<MenuButton> buttonit;
    private AMKFKone kone;

    private Käyttäjä kauttaja = new Käyttäjä();

    String lang;

    /*
    @FXML
    MenuItem kys1k;
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lang = "FI";
        locale = new Locale("fi", "FI");
        eLocale = new Locale("et", "EE");
        messages = ResourceBundle.getBundle("Controller.MessagesBundle", locale);

        kone = new AMKFKone();
        buttonit = new ArrayList<MenuButton>();
        buttonit.add(kys1);
        buttonit.add(kys2);
        buttonit.add(kys3);
        buttonit.add(kys4);
        buttonit.add(kys5);
        buttonit.add(kys6);
        buttonit.add(kys7);
        buttonit.add(kys8);
        buttonit.add(kys9);
        buttonit.add(kys10);
        buttonit.add(kys11);
        buttonit.add(kys12);
        buttonit.add(kys13);
        buttonit.add(kys14);
        buttonit.add(kys15);
        buttonit.add(kys16);
        buttonit.add(kys17);
        buttonit.add(kys18);
        buttonit.add(kys19);
        buttonit.add(kys20);
        buttonit.add(kys21);
        buttonit.add(kys22);
        kysOnAction();
        valmisOnAction();
    }

    private final String theme1Url = getClass().getResource("index_pink.css").toExternalForm();
    private final String theme2Url = getClass().getResource("index.css").toExternalForm();

    public void pinkButton(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexMusta.fxml"));/* Exception */
        Scene scene = new Scene(root);
        scene.getStylesheets().remove(theme2Url);
        System.out.println("scene stylesheets on button 1 click: " + scene.getStylesheets());
        if (!scene.getStylesheets().contains(theme1Url)) {
            scene.getStylesheets().add(theme1Url);
        }
        System.out.println("scene stylesheets on button 1 click: " + scene.getStylesheets());

    }

    @FXML
    public void whiteButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexMusta.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public void petrolButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexPetrol.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public void purpleButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexPurple.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public void greenButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indexGreen.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public void ala(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("alaPaina.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Scene vaihdettu");
    }

    @FXML
    public javafx.scene.control.Button closeButton;

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

    public void valmisOnAction() {
        System.out.println("Valmis kysely");
        kyselyValmis.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                for (int i = 0; i < buttonit.size(); i++) {
                    lisääPisteitä(i);
                }
            }
        });
    }

    @FXML
    public void language() {
        System.out.println("<<<<<<<<<<Kieli vaihdettu>>>>>>>>>>");
        if (lang.equals("FI")) {
            Locale.setDefault(eLocale);
            messages = ResourceBundle.getBundle("Controller.MessagesBundle_ee_EST", Locale.getDefault());
            lang = "EE";
        } else if (lang.equals("EE")) {
            Locale.setDefault(locale);
            messages = ResourceBundle.getBundle("Controller.MessagesBundle_fi_FI", Locale.getDefault());
            lang = "FI";
        }
        updateGUI();
    }

    public void updateGUI() {

    }

    public void kysOnAction() {

        ObservableList<MenuItem> items;
        for (int i = 0; i < 22; i++) {
            MenuButton käsiteltävä = buttonit.get(i);
            items = käsiteltävä.getItems();
            for (int j = 0; j < items.size(); j++) {
                if (j == 0) {
                    items.get(j).setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            käsiteltävä.setText("Kyllä");

                        }
                    });
                } else {
                    items.get(j).setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            käsiteltävä.setText("Ei");

                        }
                    });
                }

            }

        }

    }

    public void lisääPisteitä(int kysymysNumero) {
        System.out.println("Lisätään pisteitä");
        String vastaus = "";
        vastaus = buttonit.get(kysymysNumero).getText();
        switch (kysymysNumero) {
            //Oletko matemaattisesti lahjakas?
            case 0:
                if (vastaus.equals("Kyllä")) {
                    kone.lisääPisteitä(8, "Matemaattinen");
                    kone.lisääPisteitä(5, "Bisnes");
                    kone.lisääPisteitä(4, "Tekninen");
                    kone.lisääPisteitä(2, "Arkkitehti");
                }
                if (vastaus.equals("Ei")) {
                    kone.lisääPisteitä(-6, "Matemaattinen");
                    kone.lisääPisteitä(-3, "Bisnes");
                    kone.lisääPisteitä(-2, "Tekninen");
                }
                break;
            //Oletko kielellisesti lahjakas?
            case 1:

                if (vastaus.equals("Kyllä")) {
                    kone.lisääPisteitä(8, "Kielet");
                    kone.lisääPisteitä(5, "Bisnes");
                    kone.lisääPisteitä(3, "Johtaja");
                }
                if (vastaus.equals("Ei")){
                    kone.lisääPisteitä(-6, "Kielet");
                    kone.lisääPisteitä(2, "Kauneus");
                    kone.lisääPisteitä(2, "Urheilullinen");
                    
                }
                break;
            //Koetko taidealat tärkeäksi?
            case 2:
                
                if(vastaus.equals("Kyllä")){
                    kone.lisääPisteitä(5, "Taiteellinen");
                    kone.lisääPisteitä(3, "Arkkitehti");
                    kone.lisääPisteitä(3, "Musiikki");
                }
                if(vastaus.equals("Ei")){
                    kone.lisääPisteitä(4, "Kaytannollinen");
                    kone.lisääPisteitä(2, "Urheilullinen");
                }
                break;
            //Oletko mielelläsi ihmisten kanssa tekemisissä?
            case 3:
                
                if(vastaus.equals("Kyllä")){
                    kone.lisääPisteitä(8, "Ihmislaheinen");
                }
                if(vastaus.equals("Ei")){
                    kone.lisääPisteitä(-8, "Ihmislaheinen");
                }
                break;
            //Haaveiletko työstä markkinoinnin tai mainostamisen parissa?
            case 4:
                break;
            //Pidätkö muiden ihmisten auttamisesta?
            case 5:
                break;
            //Haluatko tehdä töitä lasten ja nuorten parissa?
            case 6:
                break;
            //Ovatko urheilu ja liikunta sinulle tärkeää?
            case 7:
                break;
            //Oletko käytännöllinen ja kätevä käsistäsi?
            case 8:
                break;
            //Tulevatko ystäväsi usein pyytämään sinulta apua ja neuvoa?
            case 9:
                break;
            //Pidätkö esiintymisestä?
            case 10:
                break;
            //Oletko valmis matkustelemaan työsi puolesta?
            case 11:
                break;
            //Pidätkö ruoanlaitosta?
            case 12:
                break;
            //Pidätkö teknisten asioiden parissa puuhailusta ja uusien laitteiden keksimisestä?
            case 13:
                break;
            //Ovatko luonnontieteet lähellä sydäntäsi?
            case 14:
                break;
            //Kiinnostaako sinua autot ja ajoneuvotekniikka?
            case 15:
                break;
            //Vietätkö paljon aikaa tietokoneella?
            case 16:
                break;
            //Pidätkö rakentamisesta ja arkkitehtuurista?
            case 17:
                break;
            //Oletko sujuva puhumaan ja haaveilet myyntityöstä?
            case 18:
                break;
            //Oletko pikkutarkka?
            case 19:
                break;
            //Ovatko ympäristöasiat lähellä sydäntäsi?
            case 20:
                break;
            //Oletko johtajatyyppiä?
            case 21:
                break;
            default:
                System.out.println("Virhehomma");
                break;

        }
    }

}
