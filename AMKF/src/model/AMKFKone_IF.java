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
public interface AMKFKone_IF {
    
    public abstract String[] getKoulutukset();
    public abstract String[] getTopKoulutukset(int määrä);
    public abstract void lisääPisteitä(int määrä, String tagi);
    public abstract String[] getAsuinalueet();
    public abstract void sulje();
}
