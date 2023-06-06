package controler;

import javax.persistence.*;
import java.util.Set;
import java.util.List;

@Entity
public class Przeglad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String opiss;
    private String data_przegladu;
    private boolean awaria;
    

   @ManyToOne
   private Maszyna maszyna;


    protected Przeglad(){}

    Przeglad(String opis, String data_przegladu, Boolean awaria){
        this.opiss = opis;
        this.data_przegladu =data_przegladu;
        this.awaria = awaria;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOpiss() {
        return opiss;
    }

    public void setOpiss(String opis) {
        opiss = opis;
    }

    public String getData_przegladu() {
        return data_przegladu;
    }

    public void setData_przegladu(String data_przegladu) {
        this.data_przegladu = data_przegladu;
    }

    public boolean isAwaria() {
        return awaria;
    }

    public void setAwaria(boolean awaria) {
        this.awaria = awaria;
    }

    public Maszyna getMaszyna() {
        return maszyna;
    }
    
    public void setMaszyna(Maszyna maszyna) {
        this.maszyna = maszyna;
    }
}
