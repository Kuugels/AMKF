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
@Table(name="käyttäjä")
public class Käyttäjä {
    
    @Column(name="nimi")
    private String nimi;
    
    @Id
    @Column(name="ID")
    private int id;
    
    @Column(name="asuinalue")
    private String asuinalue;
    
    public Käyttäjä(){
       super();
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

    public String getAsuinalue() {
        return asuinalue;
    }

    public void setAsuinalue(String asuinalue) {
        this.asuinalue = asuinalue;
    }
    
    
}
