/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Locale;

/**
 *
 * @author Samuli Käkönen
 */
public class LanguageSelection {
    
    private static LanguageSelection INSTANCE = null;
    
    private Locale locale;
    
    private LanguageSelection() {
        locale = new Locale("fi", "FI");
    }
    
    public static LanguageSelection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LanguageSelection();
        }
        return INSTANCE;
    }
    
    public void setLocale(Locale loc) {
        locale.setDefault(loc);
    }
    
}
