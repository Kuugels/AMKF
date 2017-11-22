/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Sisältää tiedon käytössä olevasta tiedosta
 *
 * @author Samuli Käkönen
 */
public class LanguageSelection {

    private static ResourceBundle messages;

    /**
     * Vaihtaa kielen viroksi
     */
    public void langEE() {
        Locale.setDefault(new Locale("et", "EE"));
        messages = ResourceBundle.getBundle("properties.MessagesBundle_ee_EST", Locale.getDefault());
    }

    /**
     * Vaihtaa kielen viroksi
     */
    public void langFI() {
        Locale.setDefault(new Locale("fi", "FI"));
        messages = ResourceBundle.getBundle("properties.MessagesBundle_fi_FI", Locale.getDefault());
    }

    /**
     * Vaihtaa kielen englanniksi
     */
    public void langGB() {
        Locale.setDefault(new Locale("en", "GB"));
        messages = ResourceBundle.getBundle("properties.MessagesBundle_en_GB", Locale.getDefault());
    }

    /**
     * Palauttaa resourceBundlen
     *
     * @return
     */
    public ResourceBundle resourceBundle() {
        return messages;
    }

}
