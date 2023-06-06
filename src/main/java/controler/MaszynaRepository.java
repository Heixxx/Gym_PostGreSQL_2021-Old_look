package controler;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaszynaRepository extends JpaRepository<Maszyna, Long> {

//    List<Klient> findByWiekGreaterThan18OrderByAgeAsc(int wiek);

}
