package controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import java.util.List;


//Dodanie osob do repozytorium na samym poczatku
@Component
public class DataLoader implements ApplicationRunner {

    private KlientRepository klientRepository;
    private SilowniaRepository silowniaRepository;
    private PrzegladRepository przegladRepository;
    private MaszynaRepository maszynaRepository;

    @Autowired
    public DataLoader(MaszynaRepository maszynaRepository, KlientRepository klientRepository, SilowniaRepository silowniaRepository, PrzegladRepository przegladRepository) {
        this.klientRepository = klientRepository;
        this.przegladRepository = przegladRepository;
        this.silowniaRepository = silowniaRepository;
        this.maszynaRepository = maszynaRepository;
    }

    public void run(ApplicationArguments args) {

        // Tworzenie silowni
        Silownia silownia = new Silownia("ActiveWorld", "Krosno", "22/03/2005");
        silowniaRepository.save(silownia);

        // Tworzenie przeglądów
        Przeglad przeglad1 = new Przeglad("Maszyna od nóg zaciela się", "25/06/2022", true);
        Przeglad przeglad2 = new Przeglad("Maszyna od klaty złamała się", "25/02/2021", false);
        przegladRepository.save(przeglad1);
        przegladRepository.save(przeglad2);

        // Tworzenie klientów
        Klient klient1 = new Klient("Adolf", "Hatler", "12/08/2001", "22/12/2022", null, 1011);
        Klient klient2 = new Klient("Arek", "Walek", "12/03/2011", "12/02/2017", null, 1022);
        Klient klient3 = new Klient("Magda", "Kadek", "12/05/1986", "24/03/2018", "25/08/2020", 1023);
        Klient klient4 = new Klient("Adam", "Władek", "12/08/2001", "02/03/2020", null, 1024);
        Klient klient5 = new Klient("admin", "admin", "00-00-0000", "00-00-0000", null, 0);

        // Przypisanie silowni do klientów
        klient1.setSilownia(silownia);
        klient2.setSilownia(silownia);
        klient3.setSilownia(silownia);
        klient4.setSilownia(silownia);
        klient5.setSilownia(silownia);

        klientRepository.save(klient1);
        klientRepository.save(klient2);
        klientRepository.save(klient3);
        klientRepository.save(klient4);
        klientRepository.save(klient5);

        // Tworzenie maszyn
        Maszyna maszyna1 = new Maszyna("Maszyna do robienia móg", "22/05/2022");
        Maszyna maszyna2 = new Maszyna("Maszyna do robienia klatki piersiowej nr.2", "22/03/2020");
        Maszyna maszyna3 = new Maszyna("Maszyna do robienia pleców", "05/05/2016");
        Maszyna maszyna4 = new Maszyna("Maszyna do robienia barków", "22/01/2016");

        // Przypisanie silowni do maszyn
        maszyna1.setSilownia(silownia);
        maszyna2.setSilownia(silownia);
        maszyna3.setSilownia(silownia);
        maszyna4.setSilownia(silownia);

        maszynaRepository.save(maszyna1);
        maszynaRepository.save(maszyna2);
        maszynaRepository.save(maszyna3);
        maszynaRepository.save(maszyna4);
    }
}
