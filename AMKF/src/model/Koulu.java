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
@Table(name="koulu")
public class Koulu {
    
    @Column(name="nimi")
    private String nimi;
    
    @Id
    @Column(name="ID")
    private int id;

    public int getId() {
        return id;
    }
    
    
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    
    

    
}
