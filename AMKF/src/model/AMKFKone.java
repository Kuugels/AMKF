/**
Luokka, josta saa string-taulukkoina tietoa tietokannasta
*/
package model;


import java.util.ArrayList;
/**
 *
 * @author mikko
 */
public class AMKFKone implements AMKFKone_IF {
    private HibisDB_IF dao = new HibisDB();
    private Koulutus[] koulutukset;
    private Asuinalue[] asuinalueet;
    
    /**
     * Haetaan tietokannasta kaikki koulutukset. Palauttaa string-taulukon
     */
    @Override
    public String[] getKoulutukset(){
        ArrayList<String> koulutusTaul = new ArrayList();
        koulutukset = dao.readKoulutukset();
        for(int i = 0; i < koulutukset.length; i++){
            String koulutus = koulutukset[i].getNimi();
            koulutusTaul.add(koulutus);
        }
        String[] koulutusStrTaul = koulutusTaul.toArray(new String[koulutusTaul.size()]); 
        return koulutusStrTaul;
    }
    
    /**Antaa string-taulukkona tietyn määrän eniten pisteitä saaneita koulutuksia
    Parametrinä annetaan määrä, kuinka monta parasta koulutusta halutaan.
    * @param määrä Annetaan lukumäärä, montako koulutusta halutaan.
    */
    @Override
    public String[] getTopKoulutukset(int määrä){
        Koulutus[] topKoulutukset = dao.getTopKoulutukset(määrä);
        String[] topKoul = new String[määrä];
        for(int i = 0; i < topKoulutukset.length; i++){
            topKoul[i] = topKoulutukset[i].getNimi();
        }
        return topKoul;
    }
    
    /**Lisätään tietty määrä pisteitä koulutuksiin, jossa on tietty tagi
     * 
     * @param pisteet montako pistettä annetaan.
     * @param tagi mille tagille pisteet annetaan.
     */
    @Override
    public void lisääPisteitä(int pisteet, String tagi){
        dao.lisääPisteitä(pisteet, tagi);
    }
    
    public void resetPisteet(){
        dao.resetAllPisteet();
    }
    
    /**
     * 
     * @return palauttaa string-taulukon kaikista asuinalueista
     */
    @Override
    public String[] getAsuinalueet(){
        ArrayList<String> alueTaul = new ArrayList();
        asuinalueet = dao.readAsuinalueet();
        for(int i = 0; i < asuinalueet.length; i++){
            String asuinalue = asuinalueet[i].getNimi();
            alueTaul.add(asuinalue);
        }
        String[] alueStrTaul = alueTaul.toArray(new String[alueTaul.size()]);
        return alueStrTaul;
    }
    
    /**
     * Suljetaan tietokantayhteys
     */
    @Override
    public void sulje(){
        dao.sulje();
    }
    
}
