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
@Table(name="mielenkiinto")
public class Mielenkiinto {
    
    @Column(name="nimi")
    private String nimi;
    
    @Id
    @Column(name="ID")
    private int id;
    
    @Column(name="käyttäjäID")
    private int käyttäjäID;

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

    public int getKäyttäjäID() {
        return käyttäjäID;
    }

    public void setKäyttäjäID(int käyttäjäID) {
        this.käyttäjäID = käyttäjäID;
    }
    
    
}
