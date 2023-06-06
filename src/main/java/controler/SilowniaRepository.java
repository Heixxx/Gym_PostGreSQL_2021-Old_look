package controler;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SilowniaRepository extends JpaRepository<Silownia, Long> {

    List<Silownia> findByNazwa(String nazwa);
    List<Silownia> findByMiejsce(String miejsce);


}
