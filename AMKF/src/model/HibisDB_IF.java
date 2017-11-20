/**
 * HibisDB-luokan rajapinta
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
