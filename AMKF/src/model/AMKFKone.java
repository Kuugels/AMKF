/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    @Override
    public String[] getTopKoulutukset(int määrä){
        Koulutus[] topKoulutukset = dao.getTopKoulutukset(määrä);
        String[] topKoul = new String[määrä];
        for(int i = 0; i < topKoulutukset.length; i++){
            topKoul[i] = topKoulutukset[i].getNimi();
        }
        return topKoul;
    }
    
    @Override
    public void lisääPisteitä(int pisteet, String tagi){
        dao.lisääPisteitä(pisteet, tagi);
    }
    
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
    
    @Override
    public void sulje(){
        dao.sulje();
    }
    
}
