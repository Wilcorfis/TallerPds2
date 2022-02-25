package co.com.poli.serviceshowtime.service;


import co.com.poli.serviceshowtime.entities.ShowTime;
import java.util.List;

public interface ShowTimesService {

    void save(ShowTime showTimes);
    void delete(ShowTime showTimes);
    List<ShowTime> findAll();
    ShowTime findById(Long id);

}
