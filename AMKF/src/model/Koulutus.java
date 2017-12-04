/**
 * Luokka, jota käytetään tietokantataulun käsittelemiseen
 */
package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author mikko
 */
@Entity
@Table(name="koulutus")
public class Koulutus {
    
    @Column(name="nimi")
    private String nimi;
    
    @Id
    @Column(name="ID")
    private int id;
    
    @Column(name="pisteet")
    private int pisteet;
    
    @Column(name="tagit")
    private String tagit;
    
    @Column(name="kuvaus")
    private String kuvaus;
    
    @Column(name="kouluID")
    private int kouluID;

    public int getKouluID() {
        return kouluID;
    }
    
    
    public String getKuvaus(){
        return kuvaus;
    }
    
    public void setKuvaus(String kuvaus){
        this.kuvaus = kuvaus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    public String getTagit() {
        return tagit;
    }

    public void setTagit(String tagit) {
        this.tagit = tagit;
    }
    
    
    
}
