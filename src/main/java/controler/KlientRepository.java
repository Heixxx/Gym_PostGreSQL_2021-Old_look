package controler;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KlientRepository extends JpaRepository<Klient, Long> {

//    List<Klient> findByWiekGreaterThan18OrderByAgeAsc(int wiek);
    List<Klient> findByImieAndNazwisko(String imie,String nazwisko);

}
