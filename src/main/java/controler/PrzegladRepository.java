package controler;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrzegladRepository extends JpaRepository<Przeglad, Long> {

//    List<Przeglad> findByWiekGreaterThan18OrderByAgeAsc(int wiek);
    List<Przeglad> findByAwaria(Boolean czy_awaria);
    List<Przeglad> findByOpiss(String opiss);
}
