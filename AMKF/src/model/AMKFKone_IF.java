/**
 * Rajapinta AMKFKoneen käyttämiseen
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
