package controler;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Maszyna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String Opis;
    private String data_Wystawienia;

   @ManyToOne
   private Silownia silownia;


    protected Maszyna(){}

    Maszyna(String Opis, String data_Wystawienia){
        this.Opis =Opis;
        this.data_Wystawienia =data_Wystawienia;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public String getData_Wystawienia() {
        return data_Wystawienia;
    }

    public void setData_Wystawienia(String data_Wystawienia) {
        this.data_Wystawienia = data_Wystawienia;
    }

    public Silownia getSilownia() {
        return silownia;
    }
 
    public void setSilownia(Silownia silownia) {
        this.silownia = silownia;
    }
}
