package co.com.poli.serviceshowtime.repository;

import co.com.poli.serviceshowtime.entities.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ShowTimesRepository extends JpaRepository<ShowTime,Long> {
}
