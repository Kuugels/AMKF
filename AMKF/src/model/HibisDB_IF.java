/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mikko
 */
public interface HibisDB_IF {
    
    public abstract Käyttäjä readKäyttäjä(int id);
    public abstract Koulutus[] readKoulutukset();
    public abstract Mielenkiinto[] readMielenkiinnot();
    public abstract boolean lisääPisteitä(int pisteet, String tagi);
    public abstract void resetAllPisteet();
    public abstract Koulutus[] getTopKoulutukset(int topMäärä);
    public abstract Asuinalue[] readAsuinalueet();
    public abstract Koulu readKoulu(int id);
    public abstract void sulje();
}
