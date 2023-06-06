package controler;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Silownia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nazwa;
    private String miejsce;
    private String rok_zalozenia;

    @OneToMany(mappedBy = "silownia")
    private Set<Klient> klient;

    @OneToMany(mappedBy = "silownia")
    private Set<Maszyna> maszyna;
    protected Silownia() {
        // Domyślny konstruktor bezparametrowy
    }

    public Silownia(String nazwa, String miejsce, String rok_zalozenia) {
        this.nazwa = nazwa;
        this.miejsce = miejsce;
        this.rok_zalozenia = rok_zalozenia;
        this.klient = null;
        this.maszyna = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public String getRok_zalozenia() {
        return rok_zalozenia;
    }

    public void setRok_zalozenia(String rok_zalozenia) {
        this.rok_zalozenia = rok_zalozenia;
    }

    public Set<Klient> getKlient() {
        return klient;
    }

    public void setKlient(Set<Klient> klient) {
        this.klient = klient;
    }

    public Set<Maszyna> getMaszyna() {
        return maszyna;
    }

    public void setMaszyna(Set<Maszyna> maszyna) {
        this.maszyna = maszyna;
    }
}
