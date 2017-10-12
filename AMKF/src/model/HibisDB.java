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
    
    @Override
    public void sulje(){
        istuntotehdas.close();
    }
    
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
        return null;
    }
    
    @Override
    public Koulu readKoulu(int id){
        return null;
    }
    
    @Override
    public Koulutus[] readKoulutukset() {
        Koulutus[] koulutusLista = null;
        try {
            istunto = istuntotehdas.openSession();
            istunto.beginTransaction();
            @SuppressWarnings("unchecked")
            List<Koulutus> result = istunto.createQuery("from Koulutus").getResultList();
            istunto.getTransaction().commit();
            koulutusLista = result.toArray(new Koulutus[result.size()]);

        } catch (Exception e) {
            if (transaktio != null) {
                transaktio.rollback();
            }
            e.printStackTrace();
        } finally {
            istunto.close();
        }
        return koulutusLista;
    }
    
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

    public String[] erotteleTagit(Koulutus koulutus) {
        String[] tagit = koulutus.getTagit().split(" ");
        return tagit;
    }
    
    

}
