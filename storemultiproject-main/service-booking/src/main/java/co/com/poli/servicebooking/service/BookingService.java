package co.com.poli.servicebooking.service;

import co.com.poli.servicebooking.entities.Booking;

import java.util.List;

public interface BookingService {

    void save(Booking booking);
    void delete(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);
    List<Booking> findByUserId(Long userId);

}
