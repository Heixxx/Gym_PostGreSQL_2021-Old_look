package controler;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import javax.persistence.*;


@Entity
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String imie;
    private String nazwisko;
    private String data_urodzenia;
    private String data_zapisania;
    private String data_zakonczenia;
    private int nr_index;

   @ManyToOne
   private Silownia silownia;


    protected Klient(){}

    Klient(String imie,String nazwisko, String data_uro,String data_zapis,String data_end,int nr_index){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_uro;
        this.data_zapisania = data_zapis;
        this. data_zakonczenia = data_end;
        this.nr_index = nr_index;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getData_zapisania() {
        return data_zapisania;
    }

    public void setData_zapisania(String data_zapisania) {
        this.data_zapisania = data_zapisania;
    }

    public String getData_zakonczenia() {
        return data_zakonczenia;
    }

    public void setData_zakonczenia(String data_zakonczenia) {
        this.data_zakonczenia = data_zakonczenia;
    }

    public int getNr_index() {
        return nr_index;
    }

    public void setNr_index(int nr_index) {
        this.nr_index = nr_index;
    }

   public Silownia getSilownia() {
       return silownia;
   }

   public void setSilownia(Silownia silownia) {
       this.silownia = silownia;
   }
}
