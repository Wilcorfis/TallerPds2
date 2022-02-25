package co.com.poli.servicebooking.repository;

import co.com.poli.servicebooking.entities.Movielist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovielistRepository extends JpaRepository<Movielist,Long> {
}
