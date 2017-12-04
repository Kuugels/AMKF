/**
 * Tämä luokka ottaa yhteyden tietokantaan ja hakee tietoa sieltä
 */

package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;
import java.util.List;


public class HibisDB implements HibisDB_IF {

    SessionFactory istuntotehdas = null;
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    Session istunto;
    Transaction transaktio = null;

    public HibisDB() {
        try {
            istuntotehdas = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Virhetta pukkaa");
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }
        
    }
    
    /**
     * Suljetaan tietokantayhteys
     */
    @Override
    public void sulje(){
        istuntotehdas.close();
    }
    
    //Palauttaa Käyttäjä-olion nykyisen käyttäjän tiedoilla
    @Override
    public Käyttäjä readKäyttäjä(int id) {
        Käyttäjä käyttäjä = new Käyttäjä();
        try {
            istunto = istuntotehdas.openSession();
            istunto.beginTransaction();
            istunto.load(käyttäjä, id);
            istunto.getTransaction().commit();
            System.out.println("Olet " + käyttäjä.getNimi());
            System.out.println("Asut paikassa " + käyttäjä.getAsuinalue());

        } catch (Exception e) {
            if (transaktio != null) {
                transaktio.rollback();
            }
            e.printStackTrace();
        } finally {
            istunto.close();
        }
        return käyttäjä;
    }
    
    /**
     *  
     * @param id Annetaan parametrina halutun koulun id
     * @return palauttaa Koulu-olion.
     */
    @Override
    public Koulu readKoulu(int id){
        return null;
    }
    
    /**
     * haetaan tietokannasta kaikki koulutuskset.
     * @return palautetaan ne Koulutus-olion taulukkona
     */
    @Override
    public Koulutus[] readKoulutukset() {
        Koulutus[] koulutusLista = null;
        Koulutus[] uusiKoulutusLista = null;
        try {
            istunto = istuntotehdas.openSession();
            istunto.beginTransaction();
            @SuppressWarnings("unchecked")
            List<Koulutus> result = istunto.createQuery("from Koulutus").getResultList();
            istunto.getTransaction().commit();
            koulutusLista = result.toArray(new Koulutus[result.size()]);
            uusiKoulutusLista = poistaDuplikaatit(koulutusLista);

        } catch (Exception e) {
            if (transaktio != null) {
                transaktio.rollback();
            }
            e.printStackTrace();
        } finally {
            istunto.close();
        }
        return uusiKoulutusLista;
    }
    
    /**
     * 
     * @return Palauttaa Mielenkiinto-olio-taulukon kaikista mielenkiinnoista
     */
    @Override
    public Mielenkiinto[] readMielenkiinnot() {
        Mielenkiinto[] mielenkLista = null;
        try {
            istunto = istuntotehdas.openSession();
            istunto.beginTransaction();
            @SuppressWarnings("unchecked")
            List<Mielenkiinto> result = istunto.createQuery("from Mielenkiinto").getResultList();
            istunto.getTransaction().commit();
            mielenkLista = result.toArray(new Mielenkiinto[result.size()]);
        } catch (Exception e) {
            if (transaktio != null) {
                transaktio.rollback();
            }
            e.printStackTrace();
        } finally {
            istunto.close();
        }

        return mielenkLista;
    }
    
    /**
     * 
     * @return Palauttaa Asuinalue-olio-taulukon kaikista asuinalueista
     */
    @Override
    public Asuinalue[] readAsuinalueet(){
        Asuinalue[] asAlueLista = null;
        try {
            istunto = istuntotehdas.openSession();
            istunto.beginTransaction();
            @SuppressWarnings("unchecked")
            List<Mielenkiinto> result = istunto.createQuery("from Asuinalue").getResultList();
            istunto.getTransaction().commit();
            asAlueLista = result.toArray(new Asuinalue[result.size()]);
        } catch (Exception e){
            if (transaktio != null) {
                transaktio.rollback();
            }
            e.printStackTrace();
        }finally{
            istunto.close();
        }
        return asAlueLista;
    }
    
    /**
     * 
     * @param id parametrinä annetaan halutun koulutuksen id:n
     * @return palauttaa Koulutus-olion
     */
    
    public Koulutus readKoulutus(int id){
        Koulutus koulutus = new Koulutus();
        try {
            istunto = istuntotehdas.openSession();
            istunto.beginTransaction();
            istunto.load(koulutus, id);
            istunto.getTransaction().commit();

        } catch (Exception e) {
            if (transaktio != null) {
                transaktio.rollback();
            }
            e.printStackTrace();
        } finally {
            istunto.close();
        }
        return koulutus;
    }
    
    /**
     * Lisätään Koulutus-tauluun pisteet-columniin pisteitä.
     * Parametrinä annetaan pisteiden määrä ja tagi. Annetaan pisteet kaikille koulutuksille, joilla on
     * kyseinen tagi.
     * 
     * @param pisteet pisteiden määrä.
     * @param tagi tagi, jolle pisteet annetaan
     * @return Palauttaa true, jos lisäys onnistui, falsen, jos ei.
     */
    @Override
    public boolean lisääPisteitä(int pisteet, String tagi) {
        boolean onnistui = false;
        Koulutus[] koulutukset = readKoulutukset();
        String[] tagit = null;
        int alotusPisteet, uudetPisteet;
        for (int i = 0; i < koulutukset.length; i++) {
            tagit = erotteleTagit(koulutukset[i]);
            for (int j = 0; j < tagit.length; j++) {
                if (tagit[j].equals(tagi)) {
                    alotusPisteet = koulutukset[i].getPisteet();
                    uudetPisteet = alotusPisteet + pisteet;
                    koulutukset[i].setPisteet(uudetPisteet);
                    istunto = istuntotehdas.openSession();
                    istunto.beginTransaction();
                    Koulutus k = (Koulutus) istunto.get(Koulutus.class, koulutukset[i].getId());
                    if (k != null) {
                        k.setPisteet(uudetPisteet);
                        onnistui = true;
                    } else {
                        System.out.println("Ei osunu tageiii");
                    }
                    istunto.getTransaction().commit();
                    istunto.close();
                }
            }
        }

        return onnistui;
    }

    /**
     * Asettaa tietokantaan jokaisen koulutuksen kohdalle pisteiden arvoksi 0
     */
    @Override
    public void resetAllPisteet() {
        Koulutus[] koulutukset = readKoulutukset();
        for (int i = 0; i < koulutukset.length; i++) {
            istunto = istuntotehdas.openSession();
            istunto.beginTransaction();
            Koulutus k = (Koulutus) istunto.get(Koulutus.class, koulutukset[i].getId());
            k.setPisteet(0);
            istunto.getTransaction().commit();
            istunto.close();
        }

    }
    /**
     * Antaa Koulutus-olio-taulukon eniten saaneista koulutuksista.
     * 
     * @param topMäärä Parametrinä annetaan määrä, kuinka monta koulutusta halutaan.
     * @return Koulutus-taulukko
     */
    @Override
    public Koulutus[] getTopKoulutukset(int topMäärä) {
        Koulutus[] koulutukset = readKoulutukset();
        Koulutus[] topKoulutukset = new Koulutus[topMäärä];
        boolean totuus = false;
        if (topMäärä > koulutukset.length) {
            topMäärä = koulutukset.length;
        }
        while (!totuus) {
            totuus = true;
            for (int i = 0; i < koulutukset.length - 1; i++) {
                Koulutus k = koulutukset[i];
                Koulutus next = koulutukset[i + 1];
                if (k.getPisteet() < next.getPisteet()) {
                    koulutukset[i] = next;
                    koulutukset[i + 1] = k;
                    totuus = false;
                }

            }
        }
        
        for (int i = 0; i < topMäärä; i++){
            topKoulutukset[i] = koulutukset[i];
        }

        return topKoulutukset;

    }
    
    /**
     * Palauttaa string-taulukon Koulutus-olion tageista.
     * @param koulutus koulutus, jonka tagit halutaan erotella
     * @return string-taulukko
     */
    public String[] erotteleTagit(Koulutus koulutus) {
        String[] tagit = koulutus.getTagit().split(" ");
        return tagit;
    }
    
    public Koulutus[] poistaDuplikaatit(Koulutus[] kaikkiKoulutukset){
        int end = kaikkiKoulutukset.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (kaikkiKoulutukset[i].getNimi().equals(kaikkiKoulutukset[j].getNimi())) {
                    int shiftLeft = j;
                    for (int k = j + 1; k < end; k++, shiftLeft++) {
                        kaikkiKoulutukset[shiftLeft] = kaikkiKoulutukset[k];
                    }
                    end--;
                    j--;
                }
            }
        }

        Koulutus[] whitelist = new Koulutus[end];
        for (int i = 0; i < end; i++) {
            whitelist[i] = kaikkiKoulutukset[i];
        }
        return whitelist;
    }
    
}
