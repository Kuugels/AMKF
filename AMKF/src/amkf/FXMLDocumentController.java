/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amkf;

import Controller.Template;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Käyttäjä;
import model.AMKFKone;
import model.LanguageSelection;

/**
 * Kontrolleri kysely sivulle
 *
 * @author Samuli Käkönen
 */
public class FXMLDocumentController extends Template implements Initializable {

    @FXML
    Button pinkButton;

    //Kyselyn valmis-button
    @FXML
    Button ready;

    //Kysymykset
    @FXML
    private Text q1;
    @FXML
    private Text q2;
    @FXML
    private Text q3;
    @FXML
    private Text q4;
    @FXML
    private Text q5;
    @FXML
    private Text q6;
    @FXML
    private Text q7;
    @FXML
    private Text q8;
    @FXML
    private Text q9;
    @FXML
    private Text q10;
    @FXML
    private Text q11;
    @FXML
    private Text q12;
    @FXML
    private Text q13;
    @FXML
    private Text q14;
    @FXML
    private Text q15;
    @FXML
    private Text q16;
    @FXML
    private Text q17;
    @FXML
    private Text q18;
    @FXML
    private Text q19;
    @FXML
    private Text q20;
    @FXML
    private Text q21;
    @FXML
    private Text q22;

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

    private Käyttäjä kauttaja = new Käyttäjä();

    String lang;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Kielipaketin alustus
        initLsMe();

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
        updateGUI();
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

    /**
     * Lähettää täytetyn kyselyn tiedot tietokantaan ja vaihtaa sivun
     * @throws IOException jeepels
     * @param e Semmone parametri nimeltä e
     */
    @FXML
    public void readyOnAction(ActionEvent e) throws IOException {
        for (int i = 0; i < buttonit.size(); i++) {
            lisääPisteitä(i);
        }
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/amkf/Koulutukset.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    /**
     * Päivittää käyttöliittymän
     */
    @Override
    public void updateGUI() {
        closeButton.setText(messages.getString("shutdown"));
        kyselyBtn.setText(messages.getString("questions"));
        koulutuksetBtn.setText(messages.getString("educations"));
        yhteystiedotBtn.setText(messages.getString("contactinfo"));
        q1.setText(messages.getString("q1"));
        q2.setText(messages.getString("q2"));
        q3.setText(messages.getString("q3"));
        q4.setText(messages.getString("q4"));
        q5.setText(messages.getString("q5"));
        q6.setText(messages.getString("q6"));
        q7.setText(messages.getString("q7"));
        q8.setText(messages.getString("q8"));
        q9.setText(messages.getString("q9"));
        q10.setText(messages.getString("q10"));
        q11.setText(messages.getString("q11"));
        q12.setText(messages.getString("q12"));
        q13.setText(messages.getString("q13"));
        q14.setText(messages.getString("q14"));
        q15.setText(messages.getString("q15"));
        q16.setText(messages.getString("q16"));
        q17.setText(messages.getString("q17"));
        q18.setText(messages.getString("q18"));
        q19.setText(messages.getString("q19"));
        q20.setText(messages.getString("q20"));
        q21.setText(messages.getString("q21"));
        q22.setText(messages.getString("q22"));
        kysOnAction();

        ObservableList<MenuItem> items;
        for (int i = 0; i < buttonit.size(); i++) {
            buttonit.get(i).setText(messages.getString("choose"));
            MenuButton käsiteltävä = buttonit.get(i);
            items = käsiteltävä.getItems();
            for (int j = 0; j < items.size(); j++) {
                if (j == 0) {
                    items.get(j).setText(messages.getString("yes"));
                } else {
                    items.get(j).setText(messages.getString("no"));
                }

            }
        }
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
                            käsiteltävä.setText(messages.getString("yes"));

                        }
                    });
                } else {
                    items.get(j).setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            käsiteltävä.setText(messages.getString("no"));

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
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(8, "Matemaattinen");
                    kone.lisääPisteitä(5, "Bisnes");
                    kone.lisääPisteitä(4, "Tekninen");
                    kone.lisääPisteitä(2, "Arkkitehti");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(-6, "Matemaattinen");
                    kone.lisääPisteitä(-3, "Bisnes");
                    kone.lisääPisteitä(-2, "Tekninen");
                }
                break;
            //Oletko kielellisesti lahjakas?
            case 1:

                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(8, "Kielet");
                    kone.lisääPisteitä(5, "Bisnes");
                    kone.lisääPisteitä(3, "Johtaja");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(-6, "Kielet");
                    kone.lisääPisteitä(2, "Kauneus");
                    kone.lisääPisteitä(2, "Urheilullinen");

                }
                break;
            //Koetko taidealat tärkeäksi?
            case 2:

                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(5, "Taiteellinen");
                    kone.lisääPisteitä(3, "Arkkitehti");
                    kone.lisääPisteitä(3, "Musiikki");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(4, "Kaytannollinen");
                    kone.lisääPisteitä(2, "Urheilullinen");
                }
                break;
            //Oletko mielelläsi ihmisten kanssa tekemisissä?
            case 3:

                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(8, "Ihmislaheinen");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(-8, "Ihmislaheinen");
                }
                break;
            //Haaveiletko työstä markkinoinnin tai mainostamisen parissa?
            case 4:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(5, "Bisnes");
                    kone.lisääPisteitä(5, "Ideoija");
                    kone.lisääPisteitä(5, "Taiteellinen");
                    kone.lisääPisteitä(5, "Tekninen");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(-3, "Bisnes");
                    kone.lisääPisteitä(3, "Autot");
                    kone.lisääPisteitä(3, "Urheilullinen");
                }
                break;
            //Pidätkö muiden ihmisten auttamisesta?
            case 5:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(5, "Ihmislaheinen");
                    kone.lisääPisteitä(5, "Empaattinen");
                    kone.lisääPisteitä(5, "Sankari");
                    kone.lisääPisteitä(5, "Pelastaja");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(3, "Huonekalut");
                    kone.lisääPisteitä(3, "Bisnes");
                    kone.lisääPisteitä(3, "Kielet");
                }
                break;
            //Haluatko tehdä töitä lasten ja nuorten parissa?
            case 6:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(7, "Ihmislaheinen");
                    kone.lisääPisteitä(9, "Empaattinen");
                    kone.lisääPisteitä(10, "Lapsirakas");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(3, "Huonekalut");
                    kone.lisääPisteitä(3, "Bisnes");
                    kone.lisääPisteitä(4, "Kielet");
                    kone.lisääPisteitä(4, "Tekninen");
                    kone.lisääPisteitä(6, "Autot");
                    kone.lisääPisteitä(3, "Tietokoneet");
                    kone.lisääPisteitä(5, "Luonnontieteet");
                    kone.lisääPisteitä(3, "Arkkitehti");
                    kone.lisääPisteitä(3, "Kokki");
                }
                break;
            //Ovatko urheilu ja liikunta sinulle tärkeää?
            case 7:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(9, "Urheilullinen");
                    kone.lisääPisteitä(4, "Kaytannollinen");
                    kone.lisääPisteitä(9, "Fysioterapia");
                    kone.lisääPisteitä(7, "Terveys");
                    kone.lisääPisteitä(7, "Hyvinvointi");
                    kone.lisääPisteitä(6, "Ruokavalio");

                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(3, "Matemaattinen");
                    kone.lisääPisteitä(3, "Kielet");
                    kone.lisääPisteitä(3, "Taiteellinen");
                }

                break;
            //Oletko käytännöllinen ja kätevä käsistäsi?
            case 8:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(5, "Taiteellinen");
                    kone.lisääPisteitä(5, "Kaytannollinen");
                    kone.lisääPisteitä(5, "Kokki");
                    kone.lisääPisteitä(5, "Tekninen");
                    kone.lisääPisteitä(5, "Autot");
                    kone.lisääPisteitä(5, "Huonekalut");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(3, "Terveys");
                    kone.lisääPisteitä(3, "Kauneus");
                    kone.lisääPisteitä(3, "Esiintyjä");
                }
                break;
            //Tulevatko ystäväsi usein pyytämään sinulta apua ja neuvoa?
            case 9:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(5, "Ihmislaheinen");
                    kone.lisääPisteitä(5, "Empaattinen");
                    kone.lisääPisteitä(7, "Johtaja");
                    kone.lisääPisteitä(2, "Esiintyjä");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(3, "Huonekalut");
                    kone.lisääPisteitä(4, "Ymparisto");
                    kone.lisääPisteitä(3, "Huonekalut");
                }
                break;
            //Pidätkö esiintymisestä?
            case 10:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(5, "Ihmislaheinen");
                    kone.lisääPisteitä(5, "Kielet");
                    kone.lisääPisteitä(7, "Johtaja");
                    kone.lisääPisteitä(8, "Esiintyjä");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Autot");
                    kone.lisääPisteitä(5, "Tekninen");
                    kone.lisääPisteitä(6, "Tietokoneet");
                    kone.lisääPisteitä(6, "Matemaattinen");
                    kone.lisääPisteitä(6, "Tietokoneet");
                }
                break;
            //Oletko valmis matkustelemaan työsi puolesta?
            case 11:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(5, "Kielet");
                    kone.lisääPisteitä(5, "Bisnes");
                    kone.lisääPisteitä(7, "Matkustelu");
                    kone.lisääPisteitä(8, "Musiikki");
                    kone.lisääPisteitä(8, "Johtaja");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Ymparisto");
                    kone.lisääPisteitä(5, "Kaytannollinen");
                    kone.lisääPisteitä(6, "Kokki");
                    kone.lisääPisteitä(6, "Hyvinvointi");
                    kone.lisääPisteitä(6, "Tekninen");
                }
                break;
            //Pidätkö ruoanlaitosta?
            case 12:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(5, "Kaytannollinen");
                    kone.lisääPisteitä(10, "Kokki");
                    kone.lisääPisteitä(7, "Terveys");
                    kone.lisääPisteitä(8, "Ruokavalio");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Matemaattinen");
                    kone.lisääPisteitä(5, "Kielet");
                    kone.lisääPisteitä(6, "Bisnes");
                    kone.lisääPisteitä(6, "Esiintyja");
                    kone.lisääPisteitä(6, "Arkkitehti");
                }
                break;
            //Pidätkö teknisten asioiden parissa puuhailusta ja uusien laitteiden keksimisestä?
            case 13:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(5, "Matemaattinen");
                    kone.lisääPisteitä(9, "Tekninen");
                    kone.lisääPisteitä(7, "Ideoija");
                    kone.lisääPisteitä(8, "Autot");
                    kone.lisääPisteitä(8, "Tietokoneet");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Sankari");
                    kone.lisääPisteitä(5, "Terveys");
                    kone.lisääPisteitä(6, "Ruokavalio");
                    kone.lisääPisteitä(6, "Esiintyjä");
                    kone.lisääPisteitä(2, "Lapsirakas");
                }
                break;
            //Ovatko luonnontieteet lähellä sydäntäsi?
            case 14:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(9, "Matemaattinen");
                    kone.lisääPisteitä(8, "Tekninen");
                    kone.lisääPisteitä(10, "Luonnontieteet");
                    kone.lisääPisteitä(4, "Ymparisto");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(4, "Matkustelu");
                    kone.lisääPisteitä(5, "Terveys");
                    kone.lisääPisteitä(6, "Kokki");
                    kone.lisääPisteitä(6, "Huonekalut");
                    kone.lisääPisteitä(6, "Vaatteet");
                }
                break;
            //Kiinnostaako sinua autot ja ajoneuvotekniikka?
            case 15:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(10, "Autot");
                    kone.lisääPisteitä(8, "Tekniikka");
                    kone.lisääPisteitä(5, "Kaytannollinen");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Musiikki");
                    kone.lisääPisteitä(5, "Kauneus");
                    kone.lisääPisteitä(6, "Vaatteet");
                    kone.lisääPisteitä(6, "Terveys");
                    kone.lisääPisteitä(6, "Eläimet");
                }
                break;
            //Vietätkö paljon aikaa tietokoneella? joo :D
            case 16:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(8, "Matemaattinen");
                    kone.lisääPisteitä(5, "Kielet");
                    kone.lisääPisteitä(7, "Tekninen");
                    kone.lisääPisteitä(10, "Tietokoneet");
                    kone.lisääPisteitä(4, "Luonnontieteet");
                    kone.lisääPisteitä(4, "Taiteellinen");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Ymparisto");
                    kone.lisääPisteitä(5, "Kaytannollinen");
                    kone.lisääPisteitä(6, "Kokki");
                    kone.lisääPisteitä(6, "Hyvinvointi");
                    kone.lisääPisteitä(6, "Urheilullinen");
                }
                break;
            //Pidätkö rakentamisesta ja arkkitehtuurista? emmä tiiä :D
            case 17:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(8, "Matemaattinen");
                    kone.lisääPisteitä(8, "Tekninen");
                    kone.lisääPisteitä(10, "Arkkitehti");
                    kone.lisääPisteitä(7, "Ideoija");
                    kone.lisääPisteitä(4, "Kaytannollinen");
                    kone.lisääPisteitä(4, "Taiteellinen");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Ymparisto");
                    kone.lisääPisteitä(5, "Johtaja");
                    kone.lisääPisteitä(6, "Kokki");
                    kone.lisääPisteitä(6, "Hyvinvointi");
                    kone.lisääPisteitä(6, "Urheilullinen");
                }
                break;
            //Oletko sujuva puhumaan ja haaveilet myyntityöstä?

            case 18:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(8, "Kielet");
                    kone.lisääPisteitä(5, "Bisnes");
                    kone.lisääPisteitä(9, "Esiintyja");
                    kone.lisääPisteitä(4, "Matkustelu");
                    kone.lisääPisteitä(4, "Johtaja");
                    kone.lisääPisteitä(4, "Assistentti");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Ymparisto");
                    kone.lisääPisteitä(5, "Tekniikka");
                    kone.lisääPisteitä(6, "Autot");
                    kone.lisääPisteitä(6, "Lapsirakas");
                    kone.lisääPisteitä(6, "Luonnontieteet");
                }
                break;
            //Oletko pikkutarkka? en :D
            case 19:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(8, "Matemaattinen");
                    kone.lisääPisteitä(5, "Kielet");
                    kone.lisääPisteitä(7, "Tekninen");
                    kone.lisääPisteitä(10, "Tietokoneet");
                    kone.lisääPisteitä(4, "Luonnontieteet");
                    kone.lisääPisteitä(5, "Tehy");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Ihmislaheinen");
                    kone.lisääPisteitä(5, "Kaytannollinen");
                    kone.lisääPisteitä(6, "Kokki");
                    kone.lisääPisteitä(6, "Hyvinvointi");
                    kone.lisääPisteitä(6, "Urheilullinen");
                }
                break;
            //Ovatko ympäristöasiat lähellä sydäntäsi? ei :D
            case 20:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(10, "Ymparisto");
                    kone.lisääPisteitä(5, "Arkkitehti");
                    kone.lisääPisteitä(7, "Empaattinen");
                    kone.lisääPisteitä(7, "Terveys");
                    kone.lisääPisteitä(6, "Hyvinvointi");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Matemaattinen");
                    kone.lisääPisteitä(5, "Bisnes");
                    kone.lisääPisteitä(2, "Esiintyjä");
                    kone.lisääPisteitä(6, "Ideoija");
                    kone.lisääPisteitä(6, "Autot");
                }
                break;
            //Oletko johtajatyyppiä? en :D
            case 21:
                if (vastaus.equals(messages.getString("yes"))) {
                    kone.lisääPisteitä(10, "Johtaja");
                    kone.lisääPisteitä(8, "Bisnes");
                    kone.lisääPisteitä(2, "Kokki");
                    kone.lisääPisteitä(3, "Sankari");
                    kone.lisääPisteitä(4, "Kielet");
                    kone.lisääPisteitä(1, "Assistentti");
                }
                if (vastaus.equals(messages.getString("no"))) {
                    kone.lisääPisteitä(7, "Ymparisto");
                    kone.lisääPisteitä(5, "Kaytannollinen");
                    kone.lisääPisteitä(6, "Eläimet");
                    kone.lisääPisteitä(6, "Hyvinvointi");
                    kone.lisääPisteitä(6, "Urheilullinen");
                }
                break;
            default:
                System.out.println("Virhehomma");
                break;

        }

    }

}
