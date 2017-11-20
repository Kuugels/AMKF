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
