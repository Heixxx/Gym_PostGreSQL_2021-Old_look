package controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class MyController {

    @Autowired
    SilowniaRepository silowniaRepository;
    @Autowired
    KlientRepository klientRepository;
    @Autowired
    PrzegladRepository przegladRepository;
    @Autowired
    MaszynaRepository maszynaRepository;

    @RequestMapping("/register")
    public String register(Model model)
    {
        Klient klient = new Klient();
        model.addAttribute("klient", klient);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model,Klient klient) {
        String imie = klient.getImie();
        String nazwisko = klient.getNazwisko();
        System.out.println(imie + nazwisko);
        int nr_index = klient.getNr_index();
        String data_uro = klient.getData_urodzenia();
        String data_roz = klient.getData_zapisania();
        String data_zak = klient.getData_zakonczenia();
        Klient kl = new Klient(imie,nazwisko,data_uro,data_roz,data_zak,nr_index);

        klientRepository.save(kl);

        model.addAttribute("imie", klient.getImie());
        model.addAttribute("nazw", klient.getNazwisko());
        return "register_info";
    }

    @RequestMapping("/dni_otwarcia")
    public String dn_otw(Model model) {

        return "dni_otwarcia";
    }

    @RequestMapping("/lista_kl")
    public String lista_kl(Model model) {
        List<Klient> list = klientRepository.findAll();
        model.addAttribute("klienci", list);
        return "lista_kl";
    }

    @RequestMapping("/lista_kl_admin")
    public String lsta_kl_(Model model) {
        List<Klient> list = klientRepository.findAll();
        model.addAttribute("list", list);



        return "lista_kl_admin";
    }

    @RequestMapping("/lista_awa")
    public String lista_awa(Model model) {
        List<Przeglad> list = przegladRepository.findAll();
        model.addAttribute("list", list);
        return "lista_awa";
    }

    @RequestMapping("/lista_awa_admin")
    public String lista_awa_admin(Model model) {
        List<Przeglad> list = przegladRepository.findAll();
        model.addAttribute("list", list);
        return "lista_awa_admin";
    }
    @RequestMapping("/lista_masz")
    public String lsta_masz(Model model) {
        List<Maszyna> list = maszynaRepository.findAll();
        model.addAttribute("list", list);



        return "lista_masz";
    }

    @RequestMapping("/logowanie")
    public String login(Model model)
    {
        Klient klientt = new Klient();
        model.addAttribute("klient", klientt);
        return "login";
    }

    @RequestMapping(value = "/logowanie", method = RequestMethod.POST)
    public String login(Model model,Klient klientt) {
        String kemail = klientt.getImie();
        String khaslo = klientt.getNazwisko();


        System.out.println(klientRepository.count() + " all acc");
        for (Klient k : klientRepository.findAll()) {
            if (kemail.equals(k.getImie()) && khaslo.equals(k.getNazwisko())) {

                model.addAttribute("imie", k.getImie());
                return "panel_admin";
            }
        }
        return "error";
    }


    @RequestMapping("/panel_admin")
    public String adm(Model model)
    {
        return "panel_admin";
    }

    @RequestMapping("/dodaj_kl")
    public String dod_kl(Model model)
    {
        Klient klient = new Klient();
        model.addAttribute("klient", klient);
        return "dodaj_kl";
    }

    @RequestMapping(value = "/dodaj_kl", method = RequestMethod.POST)
    public String dod_kl(Model model,Klient klient) {
        String imie = klient.getImie();
        String nazwisko = klient.getNazwisko();
        String datauro = klient.getData_urodzenia();
        String data_zapis = klient.getData_zapisania();
        int nrindex = klient.getNr_index();
        klientRepository.save(new Klient(imie,nazwisko,datauro,data_zapis,null,nrindex));

        return "panel_admin";
    }
    @RequestMapping("/dodaj_aw")
    public String dod_aw(Model model)
    {
        Przeglad przeglad = new Przeglad();
        model.addAttribute("aw", przeglad);
        return "dodaj_aw";
    }

    @RequestMapping(value = "/dodaj_aw", method = RequestMethod.POST)
    public String dod_aw(Model model,Przeglad przeglad) {
        String opiss = przeglad.getOpiss();
        String data = przeglad.getData_przegladu();
        boolean czy_nap = przeglad.isAwaria();
        przegladRepository.save(new Przeglad(opiss,data,czy_nap));
        System.out.println("opis: " + opiss);
        return "panel_admin";
    }

    @RequestMapping("/kasuj_aw")
    public String kasuj(Model model)
    {
        Przeglad przeglad = new Przeglad();
        model.addAttribute("aw", przeglad);
        return "kasuj_aw";
    }

    @RequestMapping(value = "/kasuj_aw", method = RequestMethod.POST)
    public String kasuj(Model model,Przeglad przeglad) {
        String opis = przeglad.getOpiss();
        List<Przeglad> list = przegladRepository.findByOpiss(opis);
        long id = list.get(0).getId();

        przegladRepository.deleteById(id);
        return "panel_admin";
    }













    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }

}

        