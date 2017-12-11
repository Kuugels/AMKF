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
    private Text kyselyTitle;


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
    
    
    int matemaattinen = 0;
        int bisnes = 0;
        int tekninen = 0;
        int arkkitehti = 0;
        int kielet = 0;
        int johtaja = 0;
        int kauneus = 0;
        int urheilullinen = 0;
        int taiteellinen = 0;
        int musiikki = 0;
        int ihmislaheinen = 0;
        int kaytannollinen = 0;
        int sankari = 0;
        int empaattinen = 0;
        int ideoija = 0;
        int autot = 0;
        int huonekalut = 0;
        int kokki = 0;
        int ymparisto = 0;
        int elaimet = 0;
        int ruokavalio = 0;
        int esiintyja = 0;
        int pelastaja = 0;
        int lapsirakas = 0;
        int tietokoneet = 0;
        int luonnontieteet = 0;
        int fysioterapia = 0;
        int terveys = 0;
        int hyvinvointi = 0;
        int matkustelu = 0;
        int vaatteet = 0;
        int tekniikka = 0;
        int assistentti = 0;
        int tehy = 0;
    

    ArrayList<MenuButton> buttonit;

    private Käyttäjä kauttaja = new Käyttäjä();

    String lang;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initLsMe();//Lataa käytetyn kielen
        createHandlers();//Luo handlerit sivupalkin nappuloille

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
        //lisääPisteitä();
        for (int i = 0; i < buttonit.size(); i++) {
            lisääPisteitä(i);
            System.out.println("---------------------ROUND " + i + " ---------------------------");
        }
        addPoints();
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
        kyselyTitle.setText(messages.getString(""));//lisätty
        ready.setText(messages.getString("ready"));//lisätty
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

    public void lisääPisteitä(int kysymysNumero) {//int kysymysNumero
        System.out.println("Lisätään pisteitä");
        String vastaus = "";
        vastaus = buttonit.get(kysymysNumero).getText();

        switch (kysymysNumero) {
            //Oletko matemaattisesti lahjakas?
            case 0:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(8, "Matemaattinen");
                    matemaattinen += 8;
                    //kone.lisääPisteitä(5, "Bisnes");
                    bisnes += 5;
                    //kone.lisääPisteitä(4, "Tekninen");
                    tekninen += 4;
                    //kone.lisääPisteitä(2, "Arkkitehti");
                    arkkitehti += 2;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(-6, "Matemaattinen");
                    matemaattinen -= 6;
                    //kone.lisääPisteitä(-3, "Bisnes");
                    bisnes -= 3;
                    //kone.lisääPisteitä(-2, "Tekninen");
                    tekninen -= 2;
                }
                break;
            //Oletko kielellisesti lahjakas?
            case 1:

                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(8, "Kielet");
                    kielet += 8;
                    //kone.lisääPisteitä(5, "Bisnes");
                    bisnes += 5;
                    //kone.lisääPisteitä(3, "Johtaja");
                    johtaja += 3;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(-6, "Kielet");
                    kielet -= 6;
                    //kone.lisääPisteitä(2, "Kauneus");
                    kauneus += 2;
                    //kone.lisääPisteitä(2, "Urheilullinen");
                    urheilullinen += 2;

                }
                break;
            //Koetko taidealat tärkeäksi?
            case 2:

                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(5, "Taiteellinen");
                    taiteellinen += 5;
                    //kone.lisääPisteitä(3, "Arkkitehti");
                    arkkitehti += 3;
                    //kone.lisääPisteitä(3, "Musiikki");
                    musiikki += 3;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(4, "Kaytannollinen");
                    kaytannollinen += 4;
                    //kone.lisääPisteitä(2, "Urheilullinen");
                    urheilullinen += 2;
                }
                break;
            //Oletko mielelläsi ihmisten kanssa tekemisissä?
            case 3:

                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(8, "Ihmislaheinen");
                    ihmislaheinen += 8;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(-8, "Ihmislaheinen");
                    ihmislaheinen -= 8;
                }
                break;
            //Haaveiletko työstä markkinoinnin tai mainostamisen parissa?
            case 4:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(5, "Bisnes");
                    bisnes += 5;
                    //kone.lisääPisteitä(5, "Ideoija");
                    ideoija += 5;
                    //kone.lisääPisteitä(5, "Taiteellinen");
                    taiteellinen += 5;
                    //kone.lisääPisteitä(5, "Tekninen");
                    tekninen += 5;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(-3, "Bisnes");
                    bisnes -= 3;
                    //kone.lisääPisteitä(3, "Autot");
                    autot += 3;
                    //kone.lisääPisteitä(3, "Urheilullinen");
                    urheilullinen += 3;
                }
                break;
            //Pidätkö muiden ihmisten auttamisesta?
            case 5:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(5, "Ihmislaheinen");
                    ihmislaheinen += 5;
                    //kone.lisääPisteitä(5, "Empaattinen");
                    empaattinen += 5;
                    //kone.lisääPisteitä(5, "Sankari");
                    sankari += 5;
                    //kone.lisääPisteitä(5, "Pelastaja");
                    pelastaja += 5;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(3, "Huonekalut");
                    huonekalut += 3;
                    //kone.lisääPisteitä(3, "Bisnes");
                    bisnes += 3;
                    //kone.lisääPisteitä(3, "Kielet");
                    kielet += 3;
                }
                break;
            //Haluatko tehdä töitä lasten ja nuorten parissa?
            case 6:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(7, "Ihmislaheinen");
                    ihmislaheinen += 7;
                    //kone.lisääPisteitä(9, "Empaattinen");
                    empaattinen += 9;
                    //kone.lisääPisteitä(10, "Lapsirakas");
                    lapsirakas += 10;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(3, "Huonekalut");
                    huonekalut += 3;
                    //kone.lisääPisteitä(3, "Bisnes");
                    bisnes += 3;
                    //kone.lisääPisteitä(4, "Kielet");
                    kielet += 4;
                    //kone.lisääPisteitä(4, "Tekninen");
                    tekninen += 4;
                    //kone.lisääPisteitä(6, "Autot");
                    autot += 6;
                    //kone.lisääPisteitä(3, "Tietokoneet");
                    tietokoneet += 3;
                    //kone.lisääPisteitä(5, "Luonnontieteet");
                    luonnontieteet += 5;
                    //kone.lisääPisteitä(3, "Arkkitehti");
                    arkkitehti += 3;
                    //kone.lisääPisteitä(3, "Kokki");
                    kokki += 3;
                }
                break;
            //Ovatko urheilu ja liikunta sinulle tärkeää?
            case 7:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(9, "Urheilullinen");
                    urheilullinen += 9;
                    //kone.lisääPisteitä(4, "Kaytannollinen");
                    kaytannollinen += 4;
                    //kone.lisääPisteitä(9, "Fysioterapia");
                    fysioterapia += 9;
                    //kone.lisääPisteitä(7, "Terveys");
                    terveys += 7;
                    //kone.lisääPisteitä(7, "Hyvinvointi");
                    hyvinvointi += 7;
                    //kone.lisääPisteitä(6, "Ruokavalio");
                    ruokavalio += 6;

                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(3, "Matemaattinen");
                    matemaattinen += 3;
                    //kone.lisääPisteitä(3, "Kielet");
                    kielet += 3;
                    //kone.lisääPisteitä(3, "Taiteellinen");
                    taiteellinen += 3;
                }

                break;
            //Oletko käytännöllinen ja kätevä käsistäsi?
            case 8:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(5, "Taiteellinen");
                    taiteellinen += 5;
                    //kone.lisääPisteitä(5, "Kaytannollinen");
                    kaytannollinen += 5;
                    //kone.lisääPisteitä(5, "Kokki");
                    kokki += 5;
                    //kone.lisääPisteitä(5, "Tekninen");
                    tekninen += 5;
                    //kone.lisääPisteitä(5, "Autot");
                    autot += 5;
                    //kone.lisääPisteitä(5, "Huonekalut");
                    huonekalut += 5;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(3, "Terveys");
                    terveys += 3;
                    //kone.lisääPisteitä(3, "Kauneus");
                    kauneus += 3;
                    //kone.lisääPisteitä(3, "Esiintyjä");
                    esiintyja += 3;
                }
                break;
            //Tulevatko ystäväsi usein pyytämään sinulta apua ja neuvoa?
            case 9:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(5, "Ihmislaheinen");
                    ihmislaheinen += 5;
                    //kone.lisääPisteitä(5, "Empaattinen");
                    empaattinen += 5;
                    //kone.lisääPisteitä(7, "Johtaja");
                    johtaja += 7;
                    //kone.lisääPisteitä(2, "Esiintyjä");
                    esiintyja += 2;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(3, "Huonekalut");
                    huonekalut += 3;
                    //kone.lisääPisteitä(4, "Ymparisto");
                    ymparisto += 4;
                    //kone.lisääPisteitä(3, "Huonekalut");
                    huonekalut += 3;
                }
                break;
            //Pidätkö esiintymisestä?
            case 10:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(5, "Ihmislaheinen");
                    ihmislaheinen += 5;
                    //kone.lisääPisteitä(5, "Kielet");
                    kielet += 5;
                    //kone.lisääPisteitä(7, "Johtaja");
                    johtaja += 7;
                    //kone.lisääPisteitä(8, "Esiintyjä");
                    esiintyja += 8;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Autot");
                    autot += 7;
                    //kone.lisääPisteitä(5, "Tekninen");
                    tekninen += 5;
                    //kone.lisääPisteitä(6, "Tietokoneet");
                    tietokoneet += 6;
                    //kone.lisääPisteitä(6, "Matemaattinen");
                    matemaattinen += 6;
                    //kone.lisääPisteitä(6, "Tietokoneet");
                    tietokoneet += 6;
                }
                break;
            //Oletko valmis matkustelemaan työsi puolesta?
            case 11:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(5, "Kielet");
                    kielet += 5;
                    //kone.lisääPisteitä(5, "Bisnes");
                    bisnes += 5;
                    //kone.lisääPisteitä(7, "Matkustelu");
                    matkustelu += 7;
                    //kone.lisääPisteitä(8, "Musiikki");
                    musiikki += 8;
                    //kone.lisääPisteitä(8, "Johtaja");
                    johtaja += 8;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Ymparisto");
                    ymparisto += 7;
                    //kone.lisääPisteitä(5, "Kaytannollinen");
                    kaytannollinen += 5;
                    //kone.lisääPisteitä(6, "Kokki");
                    kokki += 6;
                    //kone.lisääPisteitä(6, "Hyvinvointi");
                    hyvinvointi += 6;
                    //kone.lisääPisteitä(6, "Tekninen");
                    tekninen += 6;
                }
                break;
            //Pidätkö ruoanlaitosta?
            case 12:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(5, "Kaytannollinen");
                    kaytannollinen += 5;
                    //kone.lisääPisteitä(10, "Kokki");
                    kokki += 10;
                    //kone.lisääPisteitä(7, "Terveys");
                    terveys += 7;
                    //kone.lisääPisteitä(8, "Ruokavalio");
                    ruokavalio += 8;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Matemaattinen");
                    matemaattinen += 7;
                    //kone.lisääPisteitä(5, "Kielet");
                    kielet += 5;
                    //kone.lisääPisteitä(6, "Bisnes");
                    bisnes += 6;
                    //kone.lisääPisteitä(6, "Esiintyja");
                    esiintyja += 6;
                    //kone.lisääPisteitä(6, "Arkkitehti");
                    arkkitehti += 6;
                }
                break;
            //Pidätkö teknisten asioiden parissa puuhailusta ja uusien laitteiden keksimisestä?
            case 13:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(5, "Matemaattinen");
                    matemaattinen += 5;
                    //kone.lisääPisteitä(9, "Tekninen");
                    tekninen += 9;
                    //kone.lisääPisteitä(7, "Ideoija");
                    ideoija += 7;
                    //kone.lisääPisteitä(8, "Autot");
                    autot += 8;
                    //kone.lisääPisteitä(8, "Tietokoneet");
                    tietokoneet += 8;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Sankari");
                    sankari += 7;
                    //kone.lisääPisteitä(5, "Terveys");
                    terveys += 5;
                    //kone.lisääPisteitä(6, "Ruokavalio");
                    ruokavalio += 6;
                    //kone.lisääPisteitä(6, "Esiintyjä");
                    esiintyja += 6;
                    //kone.lisääPisteitä(2, "Lapsirakas");
                    lapsirakas += 2;
                }
                break;
            //Ovatko luonnontieteet lähellä sydäntäsi?
            case 14:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(9, "Matemaattinen");
                    matemaattinen += 9;
                    //kone.lisääPisteitä(8, "Tekninen");
                    tekninen += 8;
                    //kone.lisääPisteitä(10, "Luonnontieteet");
                    luonnontieteet += 10;
                    //kone.lisääPisteitä(4, "Ymparisto");
                    ymparisto += 4;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(4, "Matkustelu");
                    matkustelu += 4;
                    //kone.lisääPisteitä(5, "Terveys");
                    terveys += 5;
                    //kone.lisääPisteitä(6, "Kokki");
                    kokki += 6;
                    //kone.lisääPisteitä(6, "Huonekalut");
                    huonekalut += 6;
                    //kone.lisääPisteitä(6, "Vaatteet");
                    vaatteet += 6;
                }
                break;
            //Kiinnostaako sinua autot ja ajoneuvotekniikka?
            case 15:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(10, "Autot");
                    autot += 10;
                    //kone.lisääPisteitä(8, "Tekniikka");
                    tekniikka += 8;
                    //kone.lisääPisteitä(5, "Kaytannollinen");
                    kaytannollinen += 5;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Musiikki");
                    musiikki += 7;
                    //kone.lisääPisteitä(5, "Kauneus");
                    kauneus += 5;
                    //kone.lisääPisteitä(6, "Vaatteet");
                    vaatteet += 6;
                    //kone.lisääPisteitä(6, "Terveys");
                    terveys += 6;
                    //kone.lisääPisteitä(6, "Eläimet");
                    elaimet += 6;
                }
                break;
            //Vietätkö paljon aikaa tietokoneella? joo :D
            case 16:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(8, "Matemaattinen");
                    matemaattinen += 8;
                    //kone.lisääPisteitä(5, "Kielet");
                    kielet += 5;
                    //kone.lisääPisteitä(7, "Tekninen");
                    tekninen += 7;
                    //kone.lisääPisteitä(10, "Tietokoneet");
                    tietokoneet += 10;
                    //kone.lisääPisteitä(4, "Luonnontieteet");
                    luonnontieteet += 4;
                    //kone.lisääPisteitä(4, "Taiteellinen");
                    taiteellinen += 4;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Ymparisto");
                    ymparisto += 7;
                    //kone.lisääPisteitä(5, "Kaytannollinen");
                    kaytannollinen += 5;
                    //kone.lisääPisteitä(6, "Kokki");
                    kokki += 6;
                    //kone.lisääPisteitä(6, "Hyvinvointi");
                    hyvinvointi += 6;
                    //kone.lisääPisteitä(6, "Urheilullinen");
                    urheilullinen += 6;
                }
                break;
            //Pidätkö rakentamisesta ja arkkitehtuurista? emmä tiiä :D
            case 17:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(8, "Matemaattinen");
                    matemaattinen += 8;
                    //kone.lisääPisteitä(8, "Tekninen");
                    tekninen += 8;
                    //kone.lisääPisteitä(10, "Arkkitehti");
                    arkkitehti += 10;
                    //kone.lisääPisteitä(7, "Ideoija");
                    ideoija += 7;
                    //kone.lisääPisteitä(4, "Kaytannollinen");
                    kaytannollinen += 4;
                    //kone.lisääPisteitä(4, "Taiteellinen");
                    taiteellinen += 4;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Ymparisto");
                    ymparisto += 7;
                    //kone.lisääPisteitä(5, "Johtaja");
                    johtaja += 5;
                    //kone.lisääPisteitä(6, "Kokki");
                    kokki += 6;
                    //kone.lisääPisteitä(6, "Hyvinvointi");
                    hyvinvointi += 6;
                    //kone.lisääPisteitä(6, "Urheilullinen");
                    urheilullinen += 6;
                }
                break;
            //Oletko sujuva puhumaan ja haaveilet myyntityöstä?

            case 18:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(8, "Kielet");
                    kielet += 8;
                    //kone.lisääPisteitä(5, "Bisnes");
                    bisnes += 5;
                    //kone.lisääPisteitä(9, "Esiintyja");
                    esiintyja += 9;
                    //kone.lisääPisteitä(4, "Matkustelu");
                    matkustelu += 4;
                    //kone.lisääPisteitä(4, "Johtaja");
                    johtaja += 4;
                    //kone.lisääPisteitä(4, "Assistentti");
                    assistentti += 4;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Ymparisto");
                    ymparisto += 7;
                    //kone.lisääPisteitä(5, "Tekniikka");
                    tekniikka += 5;
                    //kone.lisääPisteitä(6, "Autot");
                    autot += 6;
                    //kone.lisääPisteitä(6, "Lapsirakas");
                    lapsirakas += 6;
                    //kone.lisääPisteitä(6, "Luonnontieteet");
                    luonnontieteet += 6;
                }
                break;
            //Oletko pikkutarkka? en :D
            case 19:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(8, "Matemaattinen");
                    matemaattinen += 8;
                    //kone.lisääPisteitä(5, "Kielet");
                    kielet += 8;
                    //kone.lisääPisteitä(7, "Tekninen");
                    tekninen += 7;
                    //kone.lisääPisteitä(10, "Tietokoneet");
                    tietokoneet += 10;
                    //kone.lisääPisteitä(4, "Luonnontieteet");
                    luonnontieteet += 4;
                    //kone.lisääPisteitä(5, "Tehy");
                    tehy += 5;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Ihmislaheinen");
                    ihmislaheinen += 7;
                    kone.lisääPisteitä(5, "Kaytannollinen");
                    kaytannollinen += 5;
                    //kone.lisääPisteitä(6, "Kokki");
                    kokki += 6;
                    //kone.lisääPisteitä(6, "Hyvinvointi");
                    hyvinvointi += 6;
                    //kone.lisääPisteitä(6, "Urheilullinen");
                    urheilullinen += 6;
                }
                break;
            //Ovatko ympäristöasiat lähellä sydäntäsi? ei :D
            case 20:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(10, "Ymparisto");
                    ymparisto += 10;
                    //kone.lisääPisteitä(5, "Arkkitehti");
                    arkkitehti += 5;
                    //kone.lisääPisteitä(7, "Empaattinen");
                    empaattinen += 7;
                    //kone.lisääPisteitä(7, "Terveys");
                    terveys += 7;
                    //kone.lisääPisteitä(6, "Hyvinvointi");
                    hyvinvointi += 6;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Matemaattinen");
                    matemaattinen += 7;
                    //kone.lisääPisteitä(5, "Bisnes");
                    bisnes += 5;
                    //kone.lisääPisteitä(2, "Esiintyjä");
                    esiintyja += 2;
                    //kone.lisääPisteitä(6, "Ideoija");
                    ideoija += 6;
                    //kone.lisääPisteitä(6, "Autot");
                    autot += 6;
                }
                break;
            //Oletko johtajatyyppiä? en :D
            case 21:
                if (vastaus.equals(messages.getString("yes"))) {
                    //kone.lisääPisteitä(10, "Johtaja");
                    johtaja += 10;
                    //kone.lisääPisteitä(8, "Bisnes");
                    bisnes += 8;
                    //kone.lisääPisteitä(2, "Kokki");
                    kokki += 2;
                    //kone.lisääPisteitä(3, "Sankari");
                    sankari += 3;
                    //kone.lisääPisteitä(4, "Kielet");
                    kielet += 4;
                    //kone.lisääPisteitä(1, "Assistentti");
                    assistentti += 1;
                }
                if (vastaus.equals(messages.getString("no"))) {
                    //kone.lisääPisteitä(7, "Ymparisto");
                    ymparisto += 7;
                    //kone.lisääPisteitä(5, "Kaytannollinen");
                    kaytannollinen += 5;
                    //kone.lisääPisteitä(6, "Eläimet");
                    elaimet += 6;
                    //kone.lisääPisteitä(6, "Hyvinvointi");
                    hyvinvointi += 6;
                    //kone.lisääPisteitä(6, "Urheilullinen");
                    urheilullinen += 6;
                }
                break;
            default:
                System.out.println("Virhehomma");
                break;

        }

    }

   
    public void addPoints() {
        kone.lisääPisteitä(matemaattinen, "Matemaattinen");
        kone.lisääPisteitä(bisnes, "Bisnes");
        kone.lisääPisteitä(tekninen, "Tekninen");
        kone.lisääPisteitä(arkkitehti, "Arkkitehti");
        kone.lisääPisteitä(kielet, "Kielet");
        kone.lisääPisteitä(johtaja, "Johtaja");
        kone.lisääPisteitä(kauneus, "Kauneus");
        kone.lisääPisteitä(urheilullinen, "Urheilullinen");
        kone.lisääPisteitä(taiteellinen, "Taiteellinen");
        kone.lisääPisteitä(musiikki, "Musiikki");
        kone.lisääPisteitä(ihmislaheinen, "Ihmisläheinen");
        kone.lisääPisteitä(kaytannollinen, "Käytännöllinen");
        kone.lisääPisteitä(sankari, "Sankari");
        kone.lisääPisteitä(empaattinen, "Empaattinen");
        kone.lisääPisteitä(ideoija, "Ideoija");
        kone.lisääPisteitä(autot, "Autot");
        kone.lisääPisteitä(huonekalut, "Huonekalut");
        kone.lisääPisteitä(kokki, "Kokki");
        kone.lisääPisteitä(ymparisto, "Ympäristö");
        kone.lisääPisteitä(elaimet, "Eläimet");
        kone.lisääPisteitä(ruokavalio, "Ruokavalio");
        kone.lisääPisteitä(esiintyja, "Esiintyjä");
        kone.lisääPisteitä(pelastaja, "Pelastaja");
        kone.lisääPisteitä(lapsirakas, "Lapsirakas");
        kone.lisääPisteitä(tietokoneet, "Tietokoneet");
        kone.lisääPisteitä(luonnontieteet, "Luonnontieteet");
        kone.lisääPisteitä(fysioterapia, "Fysioterapia");
        kone.lisääPisteitä(terveys, "Terveys");
        kone.lisääPisteitä(hyvinvointi, "Hyvinvointi");
        kone.lisääPisteitä(matkustelu, "Matkustelu");
        kone.lisääPisteitä(vaatteet, "Vaatteet");
        kone.lisääPisteitä(tekniikka, "Tekniikka");
        kone.lisääPisteitä(assistentti, "Assistentti");
        kone.lisääPisteitä(tehy, "TeHy");
    }

}
